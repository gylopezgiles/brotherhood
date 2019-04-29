package com.magneto.brotherhood.dnadetector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DNADetectorFactory {

    @Autowired
    @Qualifier("mutantDetector")
    private DNADetector mutantDNADetector;

    public DNADetector obtainDetector(DNATypes dnaTypes){
        switch (dnaTypes){
            case MUTANT:
                return mutantDNADetector;
        }
        return null;
    }
}
