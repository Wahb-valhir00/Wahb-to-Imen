package com.mootez.resvervation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mootez.resvervation.model.Avis;
import com.mootez.resvervation.repository.AvisRepository;


@Service
public class AvisService {
@Autowired
    private final AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }
    public List<Avis> getAllAvis (){
        return avisRepository.findAll();
    }
    public Avis createAvis(Avis avis){
        return avisRepository.save(avis);
    }


    
}

