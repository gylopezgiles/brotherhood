package com.magneto.brotherhood.validatorstest;

import com.magneto.brotherhood.validators.DNAValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DNAValidatorTest {

    @Autowired
    private DNAValidator dnaValidator;

    @Test(expected = IllegalArgumentException.class)
    public void testNotNull(){
        String[] dna = null;
        dnaValidator.validate(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEmpty(){
        String[] dna = {};
        dnaValidator.validate(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNitrogenousBases(){
        String[] dna = {"AhkloGA","TCC+CG","T*ATGT","AGAAGG","GCCCTA","TCCCCG"};
        dnaValidator.validate(dna);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLength(){
        String[] dna = {"ACCTGA","TCCGCG","TATGT","AGAAGG","GCCCTA","TCCCCG"};
        dnaValidator.validate(dna);
    }


}
