package com.rafael.springbootmondodb.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rafael.springbootmondodb.Repositories.PostRepositorie;
import com.rafael.springbootmondodb.domain.Post;
import com.rafael.springbootmondodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepositorie repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}