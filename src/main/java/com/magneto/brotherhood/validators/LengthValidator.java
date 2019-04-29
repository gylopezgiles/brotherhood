package com.magneto.brotherhood.validators;

public class LengthValidator implements Validator {

    @Override
    public void validate(String[] dna) {
        int chainSize = dna[0].length();
        for(String chain: dna){
            if(chain.length() != chainSize){
                throw new IllegalArgumentException("All chains in dna must have the same length");
            }
        }
    }
}
