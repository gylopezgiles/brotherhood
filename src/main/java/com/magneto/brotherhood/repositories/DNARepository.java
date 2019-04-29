package com.magneto.brotherhood.repositories;

import com.magneto.brotherhood.dnadetector.DNATypes;
import com.magneto.brotherhood.model.DNA;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends MongoRepository<DNA, String> {

    Long countByMutant(Integer dnaType);
}
