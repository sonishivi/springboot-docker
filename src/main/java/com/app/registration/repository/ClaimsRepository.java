package com.app.registration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.registration.model.Claims;

public interface ClaimsRepository extends MongoRepository<Claims, Integer> {
	

}
