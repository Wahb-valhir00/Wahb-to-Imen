package com.mootez.resvervation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mootez.resvervation.model.Reservation;


public interface ReservationRepository extends MongoRepository<Reservation,String>{
    
}

