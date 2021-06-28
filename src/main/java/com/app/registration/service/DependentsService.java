package com.app.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.Claims;
import com.app.registration.model.Dependents;
import com.app.registration.repository.ClaimsRepository;
import com.app.registration.repository.DependentsRepository;

@Service
public class DependentsService {

	@Autowired
	private DependentsRepository repo;
	
	public Dependents saveDependents(Dependents dependents) {
		System.out.println("inside service");
		return repo.save(dependents);
		
	}
	
	public List<Dependents> getAllDependentsofUser(String UserId){
		List<Dependents> dependents=repo.findAll();
		System.out.println("lists are"+dependents);
		List<Dependents> finalResult = new ArrayList<>(); ;
		for(Dependents dp : dependents) { 
			if(dp.getMemberID() != null) {
			   if(dp.getMemberID().equals(UserId) ){
				   System.out.println("inside if");
				   finalResult.add(dp);
				   
			   }
			}
		}
		return finalResult;
	
}

	public boolean limitReached(String userID) {
		List<Dependents> dependents=repo.findAll();
		int count=0;
		if(!dependents.isEmpty()) {
		 for(Dependents dp : dependents) {
			 if(dp.getMemberID() != null) {
			 if(dp.getMemberID().equals(userID)) {
				 count++;
			 }
		 }
		 }
		 if(count>=2)
		   return true;
		 else 
			 return false;
		}
		return false;
	}
	
	public void deleteDependent(String depID) {
		repo.deleteById(depID);
		
	}

	/*
	 * public Dependents getDependentByID(String depID) { List<Dependents>
	 * dependents=repo.findAll(); Dependents finalResult = new Dependents();
	 * for(Dependents dp : dependents) { if(dp.getDepID() != null) {
	 * if(dp.getDepID().equals(depID)){ System.out.println();
	 * finalResult.setDepID(dp.getDepID());
	 * finalResult.setMemberID(dp.getMemberID()); finalResult.setName(dp.getName());
	 * finalResult.set
	 * 
	 * } } } return finalResult; }
	 */

}
