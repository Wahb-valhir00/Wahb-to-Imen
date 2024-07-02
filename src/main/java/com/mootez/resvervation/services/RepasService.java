package com.mootez.resvervation.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mootez.resvervation.model.Repas;
import com.mootez.resvervation.repository.RepasRepository;



@Service

public class RepasService {
    private final RepasRepository repasRepository;

    public RepasService(RepasRepository repasRepository) {
        this.repasRepository = repasRepository;
    }
    public Repas createRepas(Repas repas){
        return repasRepository.save(repas);
    }
    public List<Repas> getAllRepas(){
        return repasRepository.findAll();
    }
    public Repas getRepasById(String id){
        return repasRepository.findById(id).orElseThrow();
    }
    public Repas updateRepas(Repas repas){
        return repasRepository.save(repas);
    } 
    public void deleteRepas(String id){
        repasRepository.deleteById(id);
    }
    
}

