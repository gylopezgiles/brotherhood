package com.magneto.brotherhood.dnaextractor;

public class DNAExtractorLeftDiagonal implements DNAExtractorStrategy {
    @Override
    public String extractNitrogenousBasesSequence(String[] dna, int quantity, int row, int column) {
        int rowSize = dna.length;
        StringBuilder nitrogenousBaseSequence = new StringBuilder();
        if((column-quantity+1) >= 0 && (row+quantity-1) < rowSize){
            for(int i = 0; i < quantity; i++){
                nitrogenousBaseSequence.append(dna[row].charAt(column));
                row++;
                column--;
            }
        }
        return nitrogenousBaseSequence.toString();
    }
}
