package com.app.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "member")
public class MemberRegistrationData {
	
	@Id
	private String memberID;
	private String mobileNumber;
	private String email;
	private String userName;
	private String dob;
	private  String panNumber;
	private String address;
	private String country;
	private String state;
	
	public MemberRegistrationData() {
		
	}
	
	public MemberRegistrationData(String mobileNumber, String email, String userName, String dob, String panNumber,
			String address, String country, String state) {
		super();
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.userName = userName;
		this.dob = dob;
		this.panNumber = panNumber;
		this.address = address;
		this.country = country;
		this.state = state;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}

