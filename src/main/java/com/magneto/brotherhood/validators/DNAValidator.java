package com.magneto.brotherhood.validators;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DNAValidator{
    List<Validator> validators = new ArrayList<>();

    public DNAValidator() {
        validators.add(new NotNullValidator());
        validators.add(new NotEmptyValidator());
        validators.add(new NitrogenousBasesValidator());
        validators.add(new LengthValidator());
    }


    public void validate(String[] dna) {
        validators.forEach(validator -> validator.validate(dna));
    }


}
