package com.app.registration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.MemberRegistrationData;
import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;



@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/signUpUser")
	@CrossOrigin(origins= "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId= user.getEmailId();
		System.out.println("the email id is "+tempEmailId);
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj= service.fetchUserByEmailId(tempEmailId);
			try {
				if(userobj != null) {
					throw new Exception("User with "+tempEmailId+" already exists");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User userObj=null;
		userObj= service.saveUser(user);
		return userObj;
		
		
	}

	@PostMapping("/login")
	@CrossOrigin(origins= "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
	String tempEmailId=user.getEmailId();
	String tempPass=user.getPassword();
	User userobj=null;
	if(tempEmailId != null && tempPass!= null) {
		userobj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);	
	}
	if(userobj == null) {
		throw new Exception("Bad credentials");
	}
	return userobj;
}
	
	@GetMapping("/getAllUsers")
	@CrossOrigin(origins= "http://localhost:4200")
	public List<User> getUsersData () {
		
		return service.getUsersData();
		
	}
	
	@PatchMapping("/registerUser/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public User registerMember(@PathVariable("id") String userID,@RequestBody User user) throws Exception {
		
		User userObj=null;
		User updatedUser=null;
		//existing User 
		userObj=service.getUserById(userID);
		userObj.setMobileNumber(user.getMobileNumber());
		userObj.setEmailId(user.getEmailId());
		userObj.setUserName(user.getUserName());
		userObj.setRegistered(true);
		userObj.setDob(user.getDob());
		userObj.setPanNumber(user.getPanNumber());
		userObj.setAddress(user.getAddress());
		userObj.setCountry(user.getCountry());
		updatedUser= service.saveUser(userObj);
		return updatedUser;
		
		
	}
	
	@PatchMapping("/updateUserDetails/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public User updateUserDetails(@PathVariable("id") String userID,@RequestBody User user) throws Exception {
		
		User userObj=null;
		User updatedUser=null;
		//existing User 
		userObj=service.getUserById(userID);
		userObj.setMobileNumber(user.getMobileNumber());
		userObj.setEmailId(user.getEmailId());
		userObj.setUserName(user.getUserName());
		userObj.setRegistered(true);
		userObj.setDob(user.getDob());
		userObj.setPanNumber(user.getPanNumber());
		userObj.setAddress(user.getAddress());
		userObj.setCountry(user.getCountry());
		updatedUser= service.saveUser(userObj);
		return updatedUser;
		
		
	}
	
	@GetMapping("/getUserDetails/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public User getMemberData (@PathVariable("id") String userID)  {
		System.out.println("inside controller"+userID);
		User userObj=null;
		userObj= service.getUserById(userID);
		return userObj;
		
	}
}
	
/*
 * @PatchMapping("/Users/{id}") public updateUser(@PathVariable("id") String
 * userId, @RequestBody User User) { System.out.println("Update User with ID = "
 * + id + "...");
 * 
 * User userObj =getMemberData(userId); User updatedUser =
 * service.saveUser(getMemberData(userId));
 * 
 * 
 * }
 */
