package com.magneto.brotherhood.dnaextractor;

public class DNAExtractorVertical implements DNAExtractorStrategy {

    @Override
    public String extractNitrogenousBasesSequence(String[] dna, int quantity, int row, int column) {
        int rowSize = dna.length;
        StringBuilder nitrogenousBaseSequence = new StringBuilder();
        if(row+quantity < rowSize){
            for(int i = 0; i < quantity; i++){
                nitrogenousBaseSequence.append(dna[row].charAt(column));
                row++;
            }
        }
        return nitrogenousBaseSequence.toString();
    }

}
