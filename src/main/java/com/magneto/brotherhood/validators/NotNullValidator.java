package com.magneto.brotherhood.validators;

public class NotNullValidator implements Validator {
    @Override
    public void validate(String[] dna) {
        if(dna == null) throw new IllegalArgumentException("dna cannot be null");
    }
}
