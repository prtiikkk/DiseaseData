package com.example.DiseaseData.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.DiseaseData.model.Disease;


/**
 * @author pratikprajapati
 *
 *         This is the repository for this Application
 */
@Repository
public interface DiseaseRepository extends MongoRepository<Disease, String> {

}
