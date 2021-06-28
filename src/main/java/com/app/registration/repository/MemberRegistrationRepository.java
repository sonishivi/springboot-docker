package com.app.registration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.registration.model.MemberRegistrationData;;

public interface MemberRegistrationRepository extends MongoRepository< MemberRegistrationData,Integer> {

	

}
