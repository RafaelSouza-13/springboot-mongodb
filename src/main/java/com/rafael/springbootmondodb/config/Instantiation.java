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
import com.rafael.springbootmondodb.dto.AuthorDto;
import com.rafael.springbootmondodb.dto.CommentDto;

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
        userRepositorie.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Adeus pessoal, irei viajar", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei bem feliz", new AuthorDto(maria));

        CommentDto c1 = new CommentDto("Boa viagem", sdf.parse("21/03/2018"), new AuthorDto(alex));
        CommentDto c2 = new CommentDto("Aproveite", sdf.parse("23/03/2018"), new AuthorDto(bob));
        CommentDto c3 = new CommentDto("Boooooa", sdf.parse("24/03/2018"), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);
        
        postRepositorie.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepositorie.save(maria);


    }
    
}
