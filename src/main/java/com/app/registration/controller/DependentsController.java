package com.app.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.Dependents;
import com.app.registration.model.User;
import com.app.registration.repository.DependentsRepository;
import com.app.registration.service.DependentsService;
import com.app.registration.service.RegistrationService;

@RestController
public class DependentsController {

	@Autowired
	private DependentsService depService;

	@Autowired
	private DependentsRepository repo;
	
	@Autowired
	private RegistrationService service;
	
	@SuppressWarnings("null")
	@PostMapping("/saveDependents/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public Dependents saveDependents(@PathVariable("id") String userID,
			@RequestBody String dependentsName) throws Exception  {
		
		System.out.println("values are "+userID +"  "+dependentsName);
			  Dependents depResult=new Dependents();
			  boolean cannotAdd=depService.limitReached(userID);
			  if(cannotAdd== false) {
			  System.out.println("in");
			  depResult.setMemberID(userID);
			  System.out.println("value");
			  depResult.setName(dependentsName);
			  User userObj=null;
			  userObj=service.getUserById(userID);
			  userObj.setDepAdded(true);
			  service.saveUser(userObj);
		  return depService.saveDependents(depResult);}
			  else {
				  throw new Exception("Limit Reached");
				  
			  }
		
	}
	
	@PutMapping("/updatedepDetails/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public Dependents updatedepDetails(@PathVariable("id") String depID,
			@RequestBody String dependentsDOB)  {
		
		Dependents depResult=new Dependents();
		List<Dependents> dependents=repo.findAll();
		//Dependents finalResult = new Dependents();
		for(Dependents depObj : dependents) { 
			if(depObj.getDepID() != null) {
			   if(depObj.getDepID().equals(depID)){
				   System.out.println("values are "+depObj.getMemberID()+"  "+depObj.getDepID()+"  "+depObj.getName());
				   depResult.setMemberID(depObj.getMemberID());
					  depResult.setDepID(depObj.getDepID());
					  depResult.setName(depObj.getName());
					  depResult.setdOB(dependentsDOB);
				   
			   }
			}
		}
		  	  
			  
		  return depService.saveDependents(depResult);	
		
	}
	
	@GetMapping("/getAllDependentsofUser/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public List<Dependents> getAllDependentsofUser (@PathVariable("id") String userID)  {
		List<Dependents> depResult= depService.getAllDependentsofUser(userID);
		return depResult;
		
	}
	
	@DeleteMapping("/deleteDependent/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public void deleteDependent (@PathVariable("id") String depID) {
		depService.deleteDependent(depID);
	}
	
	
	/*
	 * @PostMapping("/Validate Dependent")
	 * 
	 * @CrossOrigin(origins= "http://localhost:4200") public User
	 * loginUser(@RequestBody Dependent user) throws Exception { String
	 * tempEmailId=user.getEmailId(); String tempPass=user.getPassword(); User
	 * userobj=null; if(tempEmailId != null && tempPass!= null) {
	 * userobj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass); }
	 * if(userobj == null) { throw new Exception("Bad credentials"); } return
	 * userobj; }
	 */

}
