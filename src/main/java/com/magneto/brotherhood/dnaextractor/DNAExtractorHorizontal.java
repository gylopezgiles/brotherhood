package com.magneto.brotherhood.dnaextractor;

public class DNAExtractorHorizontal implements DNAExtractorStrategy {

    @Override
    public String extractNitrogenousBasesSequence(String[] dna, int quantity, int row, int column) {
        int columnSize = dna[0].length();
        StringBuilder nitrogenousBaseSequence = new StringBuilder();
        if(column+quantity-1 < columnSize){
            for(int i = 0; i < quantity; i++){
                nitrogenousBaseSequence.append(dna[row].charAt(column));
                column++;
            }
        }
        return nitrogenousBaseSequence.toString();
    }

}
