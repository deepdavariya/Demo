package com.Manish.JobPost.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Manish.JobPost.model.post;

public interface postrepo extends MongoRepository<post, String> {

}
