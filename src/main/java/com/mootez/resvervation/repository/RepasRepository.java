package com.mootez.resvervation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mootez.resvervation.model.Repas;

@Repository

public interface RepasRepository extends MongoRepository<Repas,String>  {
    
}