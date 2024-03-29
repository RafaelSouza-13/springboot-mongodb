package com.rafael.springbootmondodb.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rafael.springbootmondodb.domain.Post;

@Repository
public interface PostRepositorie extends MongoRepository<Post, String> {
    public List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    public List<Post> searchTitle(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
