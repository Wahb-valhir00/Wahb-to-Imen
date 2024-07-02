package com.mootez.resvervation.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mootez.resvervation.model.Menu;

@Repository

public interface MenuRepository extends MongoRepository<Menu,String>{

    
}