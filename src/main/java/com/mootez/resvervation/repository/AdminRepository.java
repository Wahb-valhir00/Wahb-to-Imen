package com.mootez.resvervation.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mootez.resvervation.model.Admin;

@Repository

public interface AdminRepository extends MongoRepository<Admin,String> {
    Admin findByEmailAndPassword(String email, String password);}
