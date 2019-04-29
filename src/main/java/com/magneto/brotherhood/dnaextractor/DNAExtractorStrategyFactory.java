package com.magneto.brotherhood.dnaextractor;

import org.springframework.stereotype.Component;

@Component
public class DNAExtractorStrategyFactory {

    private static DNAExtractorStrategy dnaExtractorHorizontal = new DNAExtractorHorizontal();
    private static DNAExtractorStrategy dnaExtractorVertical = new DNAExtractorVertical();
    private static DNAExtractorStrategy dnaExtractorLeftDiagonal = new DNAExtractorLeftDiagonal();
    private static DNAExtractorStrategy dnaExtractorRightDiagonal = new DNAExtractorRightDiagonal();

    public DNAExtractorStrategy obtainStrategy(StrategyEnum strategy){
        switch (strategy){
            case HORIZONTAL:
                return dnaExtractorHorizontal;
            case VERTICAL:
                return dnaExtractorVertical;
            case LEFTDIAGONAL:
                return dnaExtractorLeftDiagonal;
            case RIGHTDIAGONAL:
                return dnaExtractorRightDiagonal;
        }
        return null;
    }
}
