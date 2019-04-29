package com.magneto.brotherhood.validators;

import java.util.regex.Pattern;

public class NitrogenousBasesValidator implements Validator {
    @Override
    public void validate(String[] dna) {
        for (String chain: dna){
            if(!Pattern.compile("^[ATCGatcg]*$").matcher(chain).matches()){
               throw new IllegalArgumentException("dna can only have valid nitrogenous bases (ACGT)");
            }
        }
    }
}
