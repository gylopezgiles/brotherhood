package com.magneto.brotherhood.validators;

public class NotEmptyValidator implements Validator {
    @Override
    public void validate(String[] dna) {
        if(dna.length < 1) throw new IllegalArgumentException("dna must have elements");
    }
}
