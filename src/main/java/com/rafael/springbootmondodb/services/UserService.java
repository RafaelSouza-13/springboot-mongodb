package com.rafael.springbootmondodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.springbootmondodb.Repositories.UserRepositorie;
import com.rafael.springbootmondodb.domain.User;

@Service
public class UserService {
    @Autowired
    private UserRepositorie repository;


    public List<User> findAll(){
        return repository.findAll();
    }
}
