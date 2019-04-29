package com.magneto.brotherhood.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Stats {

    @JsonProperty("count_mutant_dna")
    private Long mutantQuantity;

    @JsonProperty("count_human_dna")
    private Long humanQuantity;

    private Double ratio;

    public Stats(Long mutantQuantity, Long humanQuantity) {
        this.mutantQuantity = mutantQuantity;
        this.humanQuantity = humanQuantity;
        this.ratio = calculateRatio();
    }

    private Double calculateRatio(){
        ratio = 0.0;
        if(mutantQuantity != 0L && humanQuantity != 0L){
            ratio = mutantQuantity.doubleValue()/humanQuantity;
        } else if (mutantQuantity != 0){
            ratio = mutantQuantity.doubleValue();
        }
        return ratio;
    }

}
