package com.app.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.MemberRegistrationData;
import com.app.registration.repository.MemberRegistrationRepository;

@Service
public class MemberRegistrationService  {
	
	@Autowired
	private MemberRegistrationRepository repo;
	
	public MemberRegistrationData saveUser(MemberRegistrationData member) {
		return repo.save(member);
			
	}
	
	public Optional<MemberRegistrationData> getMemberDetails(Integer memberID) {
		
		return repo.findById(memberID);	
	}

	


}
