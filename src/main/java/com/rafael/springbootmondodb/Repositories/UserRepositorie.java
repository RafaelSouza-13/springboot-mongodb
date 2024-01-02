package com.rafael.springbootmondodb.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.springbootmondodb.domain.User;

@Repository
public interface UserRepositorie extends MongoRepository<User, String> {
    
}
