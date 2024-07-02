package com.mootez.resvervation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mootez.resvervation.model.Ingredient;

@Repository

public interface IngredientRepository extends MongoRepository<Ingredient,String> {
    
}
