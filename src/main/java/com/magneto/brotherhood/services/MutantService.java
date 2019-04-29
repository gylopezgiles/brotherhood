package com.magneto.brotherhood.services;

import com.magneto.brotherhood.dnadetector.DNADetector;
import com.magneto.brotherhood.dnadetector.DNADetectorFactory;
import com.magneto.brotherhood.dnadetector.DNATypes;
import com.magneto.brotherhood.helpers.HashHelper;
import com.magneto.brotherhood.model.DNA;
import com.magneto.brotherhood.repositories.DNARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class MutantService{

    @Autowired
    private DNARepository dnaRepository;

    @Autowired
    private  DNADetectorFactory dnaDetectorFactory;

    @Autowired
    private StatisticsCacheService statisticsCacheService;

    public Boolean checkDNA(String[] dna) {
        Boolean isMutant = isMutant(dna);
        saveDNA(dna, isMutant);
        return isMutant;
    }

    public Boolean isMutant(String[] dna){
        DNADetector mutantDetector = dnaDetectorFactory.obtainDetector(DNATypes.MUTANT);
        return mutantDetector.detectedDNA(dna);
    }

    private void saveDNA(String[] dna, Boolean isMutant){
        DNA dnaToSave = new DNA();
        dnaToSave.setHash(HashHelper.generateHashByString(dna));
        dnaToSave.setSequence(Arrays.toString(dna));
        DNATypes dnaType = (isMutant) ? DNATypes.MUTANT : DNATypes.HUMAN;
        dnaToSave.setMutant(dnaType);
        dnaRepository.save(dnaToSave);
        statisticsCacheService.invalidateCache(dnaType);
    }




}
