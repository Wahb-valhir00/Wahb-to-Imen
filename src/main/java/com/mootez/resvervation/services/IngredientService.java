package com.mootez.resvervation.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mootez.resvervation.model.Ingredient;
import com.mootez.resvervation.repository.IngredientRepository;


@Service

public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public Ingredient createIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
    public Ingredient getIngredientById(String id){
        return ingredientRepository.findById(id).orElseThrow();
    }
    public List<Ingredient> getAllIngredient(){
        return ingredientRepository.findAll();
    }
    public Ingredient updateIngredient(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }
    public void deleteIngredient(String id){
        ingredientRepository.deleteById(id);
    }
    
}
