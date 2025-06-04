package com.jwt.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.Entity.User;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    
    // Find by username (case-sensitive)
    Optional<User> findByUsername(String username);
}