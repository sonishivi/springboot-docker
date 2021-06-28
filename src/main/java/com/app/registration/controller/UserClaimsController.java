package com.app.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Claims;
import com.app.registration.model.User;
import com.app.registration.service.ClaimsService;
import com.app.registration.service.RegistrationService;

@RestController
public class UserClaimsController {
	@Autowired
	private RegistrationService service;
	
	@Autowired
	private ClaimsService claimService;

	
	@PostMapping("/saveUserClaims/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public Claims registerMember(@PathVariable("id") String userID,
			@RequestBody Claims claims) throws Exception {
		
		User userObj=null;
		User updatedUser=null;
		
		Claims claimObj=null;
		claims.setMemberID(userID);
		claimObj=claimService.saveUser(claims);
		
		
		  //existing 
		  userObj=service.getUserById(userID);
		   
		  updatedUser= service.saveUser(userObj);
		 
		return claimObj;
		
		
	}
	
	@GetMapping("/getAllCalimsByUser/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public List<Claims> getAllCalimsByUser (@PathVariable("id") String userID)  {
		List<Claims> claimsResult= claimService.getAllCalimsByUser(userID);
		return claimsResult;
		
	}
	
	@PutMapping("/updateClaimDetails/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public Claims updateClaimDetails(@PathVariable("id") String claimID,@RequestBody Claims claim) throws Exception {
		
		Claims claimObj=null;
		Claims claimsResult= claimService.getClaimById(claimID);
		claim.setMemberID(claimsResult.getMemberID());
		claim.setClaimID(claimID);
		claim.setProviderName(claim.getProviderName());
		claimObj=claimService.saveUser(claim);
		
		return claimObj;
		
		
		
	}
	
	
	
}
