package com.mootez.resvervation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mootez.resvervation.model.Avis;


public interface AvisRepository extends MongoRepository<Avis,String>{
    
}
