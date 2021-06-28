package com.app.registration.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	private String password;
	private String cPassword;
	private String dob;
	private String mobileNumber;
	private String userName;
	private  String panNumber;
	private String address;
	private String country;
	private String state;
	private boolean registered;
	@DBRef
	private Claims claims;
	
	private boolean depAdded;
	
    public User() {
		
	}
    
	
	public User(String id, String firstName, String lastName, String emailId, String password, String cPassword,
			String dob, String mobileNumber,  String userName, String panNumber, String address,
			String country, String state,Claims claims,boolean depAdded) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.cPassword = cPassword;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.panNumber = panNumber;
		this.address = address;
		this.country = country;
		this.state = state;
		this.claims=claims;
		//this.dependents=dependents;
		this.depAdded=depAdded;
	}





	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}





	public boolean isRegistered() {
		return registered;
	}





	public void setRegistered(boolean registered) {
		this.registered = registered;
	}


	public Claims getClaims() {
		return claims;
	}


	/*
	 * public Dependents getDependents() { return dependents; }
	 * 
	 * 
	 * public void setDependents(Dependents dependents) { this.dependents =
	 * dependents; }
	 */


	public void setClaims(Claims claims) {
		this.claims = claims;
	}


	public boolean isDepAdded() {
		return depAdded;
	}


	public void setDepAdded(boolean depAdded) {
		this.depAdded = depAdded;
	}
}
