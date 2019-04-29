package com.magneto.brotherhood.dnaextractor;

public interface DNAExtractorStrategy {
    String extractNitrogenousBasesSequence(String[] dna, int quantity, int row, int column);
}
