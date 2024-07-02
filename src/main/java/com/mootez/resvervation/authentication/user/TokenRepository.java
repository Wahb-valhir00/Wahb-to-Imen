package com.mootez.resvervation.authentication.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token, String> {
    Optional<Token> findByToken(String token);
}
