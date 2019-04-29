package com.magneto.brotherhood.model;

import com.magneto.brotherhood.dnadetector.DNATypes;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "dna")
public class DNA {

    @Id
    private String hash;

    private String sequence;

    @Indexed
    private Integer mutant;

    public void setMutant(DNATypes dnaType){
        this.mutant = dnaType.getValue();
    }
}
