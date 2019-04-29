package com.magneto.brotherhood.dnaextractortests;

import com.magneto.brotherhood.dnaextractor.DNAExtractorStrategy;
import com.magneto.brotherhood.dnaextractor.DNAExtractorVertical;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DNAExtractorVerticalTests {

    DNAExtractorStrategy dnaExtractorStrategy = new DNAExtractorVertical();

    @Test
    public void testGetNitrogenousBasesSequence() {
        //Given
        String[] dna = {"AAAAGA","TCCCCG","TTATGT","AGAAGG","GCCCTA","TCCCCG"};
        int quantity = 4;
        int row = 0;
        int column = 0;
        //When
        String nitrogenousBaseSequence = dnaExtractorStrategy.extractNitrogenousBasesSequence(dna, quantity, row, column);
        //Then
        assert(!nitrogenousBaseSequence.isEmpty());
    }


}
