package com.rafael.springbootmondodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.springbootmondodb.Repositories.UserRepositorie;
import com.rafael.springbootmondodb.domain.User;
import com.rafael.springbootmondodb.dto.UserDto;
import com.rafael.springbootmondodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepositorie repository;


    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User fromDto(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
