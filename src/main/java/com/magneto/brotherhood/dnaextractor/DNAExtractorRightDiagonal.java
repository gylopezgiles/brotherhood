package com.magneto.brotherhood.dnaextractor;

public class DNAExtractorRightDiagonal implements DNAExtractorStrategy {
    @Override
    public String extractNitrogenousBasesSequence(String[] dna, int quantity, int row, int column) {
        int rowSize = dna.length;
        int columnSize = dna[0].length();
        StringBuilder nitrogenousBaseSequence = new StringBuilder();
        if((column+quantity-1) < columnSize && (row+quantity-1) < rowSize){
            for(int i = 0; i < quantity; i++){
                nitrogenousBaseSequence.append(dna[row].charAt(column));
                row ++;
                column ++;
            }
        }
        return nitrogenousBaseSequence.toString();
    }
}
