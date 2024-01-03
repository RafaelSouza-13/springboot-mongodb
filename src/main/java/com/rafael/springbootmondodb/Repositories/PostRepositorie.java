package com.rafael.springbootmondodb.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.springbootmondodb.domain.Post;

@Repository
public interface PostRepositorie extends MongoRepository<Post, String> {
    public List<Post> findByTitleContainingIgnoreCase(String text);
}
