package com.app.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dependents")
public class Dependents {
	
	@Id
	private String depID;
	private String name;
	private String dOB;
	private String memberID;
	private String claimID;
	private boolean added;
	
	public Dependents(String depID, String name, String dOB, String memberID, String claimID, boolean added) {
		super();
		this.depID = depID;
		this.name = name;
		this.dOB = dOB;
		this.memberID = memberID;
		this.claimID = claimID;
		this.added = added;
	}
	public Dependents() {
		// TODO Auto-generated constructor stub
	}
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getdOB() {
		return dOB;
	}
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getClaimID() {
		return claimID;
	}
	public void setClaimID(String claimID) {
		this.claimID = claimID;
	}
	public boolean isAdded() {
		return added;
	}
	public void setAdded(boolean added) {
		this.added = added;
	}
	
	
	
}
