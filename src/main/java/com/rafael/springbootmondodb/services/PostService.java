package com.rafael.springbootmondodb.services;

import java.util.Date;
import java.util.List;
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
    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
