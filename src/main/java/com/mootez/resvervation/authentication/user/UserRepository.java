package com.mootez.resvervation.authentication.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mootez.resvervation.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

}
