package com.mootez.resvervation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mootez.resvervation.model.Role;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(String name);
}
