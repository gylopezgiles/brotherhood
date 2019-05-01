package com.magneto.brotherhood.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magneto.brotherhood.dnadetector.DNADetector;
import com.magneto.brotherhood.dnadetector.DNADetectorFactory;
import com.magneto.brotherhood.dnadetector.DNATypes;
import com.magneto.brotherhood.helpers.HashHelper;
import com.magneto.brotherhood.model.DNA;
import com.magneto.brotherhood.queue.RabbitMqConfiguration;
import com.magneto.brotherhood.repositories.DNARepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class MutantService{

    private Logger logger = LogManager.getLogger(MutantService.class);

    @Autowired
    private DNARepository dnaRepository;

    @Autowired
    private  DNADetectorFactory dnaDetectorFactory;

    @Autowired
    private StatisticsCacheService statisticsCacheService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Boolean checkDNA(String[] dna) {
        Boolean isMutant = isMutant(dna);
        DNA dnaResult = buildDNA(dna, isMutant);
        queueDna(dnaResult);
        return isMutant;
    }

    public Boolean isMutant(String[] dna){
        DNADetector mutantDetector = dnaDetectorFactory.obtainDetector(DNATypes.MUTANT);
        return mutantDetector.detectedDNA(dna);
    }

    private void queueDna(DNA dna){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(dna);
            logger.info("jsonString to send: " + jsonString);
            rabbitTemplate.convertAndSend(RabbitMqConfiguration.EXCHANGE_NAME, RabbitMqConfiguration.ROUTING_KEY, jsonString);
        } catch (JsonProcessingException e){

        }

    }

    private DNA buildDNA(String[] dna, Boolean isMutant) {
        DNA dnaToSave = new DNA();
        dnaToSave.setHash(HashHelper.generateHashByString(dna));
        dnaToSave.setSequence(Arrays.toString(dna));
        DNATypes dnaType = (isMutant) ? DNATypes.MUTANT : DNATypes.HUMAN;
        dnaToSave.setMutant(dnaType);
        return dnaToSave;
    }

    public void saveDNA(DNA dna){
        dnaRepository.save(dna);
        statisticsCacheService.invalidateCache(DNATypes.valueOf(dna.getMutant()));
    }




}
