package com.app.registration.service;

import java.util.ArrayList;
import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Claims;
import com.app.registration.model.User;
import com.app.registration.repository.ClaimsRepository;

@Service
public class ClaimsService {

	@Autowired
	private ClaimsRepository repo;
	
	public Claims saveUser(Claims claims) {
		return repo.save(claims);
		
	}
	
	public List<Claims> getAllCalimsByUser(String UserId){
		List<Claims> claims=repo.findAll();
		System.out.println("lists are"+claims);
		List<Claims> finalResult = new ArrayList<>(); ;
		for(Claims claimsByUser : claims) { 
			if(claimsByUser.getMemberID() != null) {
			   if(claimsByUser.getMemberID().equals(UserId) ){
				   System.out.println("inside if");
				   finalResult.add(claimsByUser);
				   
			   }
			}
		}
		return finalResult;
	
}

	public Claims getClaimById(String claimID) {
		Claims  claimsObj =null;
		List<Claims> claims=repo.findAll();
		for(Claims claim : claims) { 
				   if(claim.getClaimID().equals(claimID)){ 
					   claimsObj=claim;
				   }
	   	
	}
		return  claimsObj;
   }

}
