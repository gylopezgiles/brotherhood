package com.magneto.brotherhood.services;

import com.magneto.brotherhood.dnadetector.DNATypes;
import com.magneto.brotherhood.model.DNA;
import com.magneto.brotherhood.model.Stats;
import com.magneto.brotherhood.repositories.DNARepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class StatisticsCacheService {

    private Logger logger = LogManager.getLogger(StatisticsCacheService.class);

    @Autowired
    private CacheService cacheService;
    @Autowired
    private DNARepository dnaRepository;

    private static final String KEY_MUTANT_AMOUNT = "mutant-amount";
    private static final String KEY_HUMAN_AMOUNT = "human-amount";

    public Stats fetchStats(){
        Long mutantQuantity = cacheService.getContentInMemCache(KEY_MUTANT_AMOUNT, Long.class);
        Long humanQuantity = cacheService.getContentInMemCache(KEY_HUMAN_AMOUNT, Long.class);
        if(mutantQuantity == null || humanQuantity == null){
            mutantQuantity = dnaRepository.countByMutant(DNATypes.MUTANT.getValue());
            logger.info("mutant" + mutantQuantity.toString());
            humanQuantity = dnaRepository.countByMutant(DNATypes.HUMAN.getValue());
            logger.info("human:" + humanQuantity.toString());
            fillCacheValues(mutantQuantity, humanQuantity);
        }
        return new Stats(mutantQuantity, humanQuantity);

    }

    private void fillCacheValues(Long mutantQuantity, Long humanQuantity){
        cacheService.putContentInMemCache(KEY_HUMAN_AMOUNT, humanQuantity);
        cacheService.putContentInMemCache(KEY_MUTANT_AMOUNT, mutantQuantity);
    }

    public void invalidateCache(DNATypes dnaType){
        String keyToDelete = dnaType == DNATypes.MUTANT ? KEY_MUTANT_AMOUNT : KEY_HUMAN_AMOUNT;
        cacheService.deleteContentFromMemCache(keyToDelete);
    }

}
