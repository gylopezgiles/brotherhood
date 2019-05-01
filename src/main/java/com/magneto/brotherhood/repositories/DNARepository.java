package com.magneto.brotherhood.repositories;

import com.magneto.brotherhood.model.DNA;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DNARepository extends MongoRepository<DNA, String> {

    Long countByMutant(Integer dnaType);
}
