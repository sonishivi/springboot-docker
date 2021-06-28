package com.app.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.MemberRegistrationData;
import com.app.registration.service.MemberRegistrationService;

@RestController
public class MemberRegistrationController {
	
	@Autowired
	private MemberRegistrationService service;
	
	/*
	 * @PostMapping("/registerMember")
	 * 
	 * @CrossOrigin(origins= "http://localhost:4200") public MemberRegistrationData
	 * registerMember(@RequestBody MemberRegistrationData member) throws Exception {
	 * 
	 * MemberRegistrationData memberObj=null; memberObj= service.saveUser(member);
	 * return memberObj;
	 * 
	 * 
	 * }
	 * 
	 * @PostMapping("/getMemberDetails")
	 * 
	 * @CrossOrigin(origins= "http://localhost:4200") public
	 * Optional<MemberRegistrationData> getMemberData (@RequestBody Integer
	 * memberID) {
	 * 
	 * return service.getMemberDetails(memberID);
	 * 
	 * }
	 */
	
	
	
}
