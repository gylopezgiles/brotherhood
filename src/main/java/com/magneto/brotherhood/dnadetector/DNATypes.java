package com.magneto.brotherhood.dnadetector;

public enum DNATypes {
    MUTANT(0),
    HUMAN(1);

    private int value;

    public int getValue(){
        return value;
    }

    DNATypes(int value) {
        this.value = value;
    }
}
