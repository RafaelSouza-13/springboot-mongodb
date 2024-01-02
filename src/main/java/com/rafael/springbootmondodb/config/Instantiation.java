package com.rafael.springbootmondodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.springbootmondodb.Repositories.UserRepositorie;
import com.rafael.springbootmondodb.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepositorie repositorie;

    @Override
    public void run(String... args) throws Exception {
        repositorie.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repositorie.saveAll(Arrays.asList(maria, alex, bob));
    }
    
}
