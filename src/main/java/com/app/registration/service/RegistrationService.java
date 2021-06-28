package com.app.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoOperations;

import com.app.registration.model.MemberRegistrationData;
import com.app.registration.model.User;
import com.app.registration.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
		
	}
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		
		return repo.findByEmailIdAndPassword(email,password);
	}

	public List<User> getallUsers() {
		return repo.findAll();
	}
	
	public  List<User> getUsersData() {
		return repo.findAll();
		
	}
	
		
   public User getUserById(String userId) {
	   
	    User  userObj =null;
		System.out.println("the id is "+userId);
		List<User> users=repo.findAll();
		for(User user : users) { 
				   if(user.getId().equals(userId)){ 
				       userObj=user;
				   }
	   	
	}
		return  userObj;
   }

public User findOne(String id) {
	
	return null;
}
   
   
	 

}
