package com.mootez.resvervation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mootez.resvervation.model.Ingredient;
import com.mootez.resvervation.services.IngredientService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @GetMapping("all")
    public ResponseEntity<List<Ingredient>> getAllIngredient(){
        List<Ingredient> allIngredients=ingredientService.getAllIngredient();
        return new ResponseEntity<>(allIngredients,HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable String id){
        Ingredient ingredient=ingredientService.getIngredientById(id);
        if (ingredient != null) {
            return new ResponseEntity<>(ingredient,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<Ingredient> createIngredient (@RequestBody Ingredient ingredient){
        Ingredient newIngredient = ingredientService.createIngredient(ingredient);
        return new ResponseEntity<>(newIngredient,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient ingredient,@PathVariable String id ){
        ingredient.setId(id);
        Ingredient updatedIngredient = ingredientService.updateIngredient(ingredient);
        return new ResponseEntity<>( updatedIngredient,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable String id){
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    

}
