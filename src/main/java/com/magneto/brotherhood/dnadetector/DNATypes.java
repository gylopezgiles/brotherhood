package com.magneto.brotherhood.dnadetector;

import java.util.HashMap;
import java.util.Map;

public enum DNATypes {
    MUTANT(0),
    HUMAN(1);

    private int value;
    private static Map<Integer, DNATypes> map = new HashMap<>();

    static {
        for (DNATypes dnaType: DNATypes.values()){
            map.put(dnaType.value, dnaType);
        }
    }

    public int getValue(){
        return value;
    }

    public static DNATypes valueOf(Integer value){
        return map.get(value);
    }

    DNATypes(int value) {
        this.value = value;
    }
}
