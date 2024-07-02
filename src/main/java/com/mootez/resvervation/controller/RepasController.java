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

import com.mootez.resvervation.model.Repas;
import com.mootez.resvervation.services.RepasService;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/repas")

public class RepasController {
    private final RepasService repasService;

    public RepasController(RepasService repasService) {
        this.repasService = repasService;
    }
    @PostMapping("/create")
public ResponseEntity<Repas> createRepas(@RequestBody Repas repas){
    Repas createdRepas = repasService.createRepas(repas);
    return new ResponseEntity<>(createdRepas,HttpStatus.CREATED);
}

    @GetMapping("/all")
    public ResponseEntity<List<Repas>> getAllRepas(){
        List<Repas> repass= repasService.getAllRepas();
        return new ResponseEntity<>(repass,HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Repas> getRepasById(@PathVariable String id){
        Repas repas = repasService.getRepasById(id);
        if (repas != null) {
            return new ResponseEntity<>(repas,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Repas> updateRepas(@RequestBody Repas repas , @PathVariable String id){
        repas.setId(id);
        Repas updatedRepas = repasService.updateRepas(repas);
        return new ResponseEntity<>(updatedRepas,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRepasById(@PathVariable String id){
    repasService.deleteRepas(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
    }
    
    
}