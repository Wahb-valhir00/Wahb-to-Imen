package com.mootez.resvervation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mootez.resvervation.model.Avis;
import com.mootez.resvervation.services.AvisService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/avis")

public class AvisController {
    @Autowired
  private final AvisService adAvisService;

public AvisController(AvisService adAvisService) {
    this.adAvisService = adAvisService;
}
@PostMapping("/create")
public ResponseEntity<Avis> createAvis(Avis avis){
    Avis createdAvis=adAvisService.createAvis(avis);
    return new ResponseEntity<>(createdAvis,HttpStatus.CREATED);
    
}



    
}

