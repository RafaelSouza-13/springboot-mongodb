package com.rafael.springbootmondodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafael.springbootmondodb.Repositories.PostRepositorie;
import com.rafael.springbootmondodb.Repositories.UserRepositorie;
import com.rafael.springbootmondodb.domain.Post;
import com.rafael.springbootmondodb.domain.User;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepositorie userRepositorie;
    @Autowired
    private PostRepositorie postRepositorie;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepositorie.deleteAll();
        postRepositorie.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Adeus pessoal, irei viajar", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei bem leizs", maria);

        userRepositorie.saveAll(Arrays.asList(maria, alex, bob));
        postRepositorie.saveAll(Arrays.asList(post1, post2));


    }
    
}
