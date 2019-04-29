package com.magneto.brotherhood.dnadetector;

import com.magneto.brotherhood.dnaextractor.DNAExtractorStrategy;
import com.magneto.brotherhood.dnaextractor.DNAExtractorStrategyFactory;
import com.magneto.brotherhood.dnaextractor.StrategyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mutantDetector")
public class MutantDNADetector implements DNADetector {

    @Autowired
    DNAExtractorStrategyFactory dnaExtractorStrategyFactory;

    @Override
    public Boolean detectedDNA(String[] dna) {
        int chainsSize = dna.length;
        int nitrogenousBaseSize = dna[0].length();
        int mutantDnaDetected = 0;
        for (int chainPosition = 0; chainPosition < chainsSize && mutantDnaDetected <= 1; chainPosition++){
            for (int nitrogenousBasePosition = 0; nitrogenousBasePosition < nitrogenousBaseSize && mutantDnaDetected <= 1; nitrogenousBasePosition++){
                mutantDnaDetected += obtainMutantDnaDetectedByStrategy(dna, chainPosition, nitrogenousBasePosition, StrategyEnum.HORIZONTAL) +
                        obtainMutantDnaDetectedByStrategy(dna, chainPosition, nitrogenousBasePosition, StrategyEnum.VERTICAL) +
                        obtainMutantDnaDetectedByStrategy(dna, chainPosition, nitrogenousBasePosition, StrategyEnum.LEFTDIAGONAL) +
                        obtainMutantDnaDetectedByStrategy(dna, chainPosition, nitrogenousBasePosition, StrategyEnum.RIGHTDIAGONAL);
            }
        }
        return mutantDnaDetected > 1;
    }

    private int obtainMutantDnaDetectedByStrategy(String[] dna, int chainPosition, int nitrogenousBasePosition, StrategyEnum strategy) {
        DNAExtractorStrategy dnaExtractorStrategy = dnaExtractorStrategyFactory.obtainStrategy(strategy);
        String nitrogenousBaseSequence = dnaExtractorStrategy.extractNitrogenousBasesSequence(dna,4,chainPosition,nitrogenousBasePosition);
        if(!nitrogenousBaseSequence.isEmpty() && areAllBasesEquals(nitrogenousBaseSequence)){
            return 1;
        }
        return 0;
    }

    private Boolean areAllBasesEquals(String bases){
        for (int i = 0; i < bases.length(); i++){
            if(bases.charAt(i) != bases.charAt(0)){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

}
