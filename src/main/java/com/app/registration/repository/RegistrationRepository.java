package com.app.registration.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.registration.model.User;


public interface RegistrationRepository extends MongoRepository<User, Integer>{
	
	public User findByEmailId(String emailId);

	public User findByEmailIdAndPassword(String email, String password);

	public User findById(String id);

}
