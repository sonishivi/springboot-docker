package com.app.registration.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "claims")
public class Claims {

	private String memberID;
	@Id
	private String claimID;
	private String custName;
	private String dob;
	private String doadmission;
	private String doDischarge;
	private String providerName;
	private Integer billAmt;
	private String type;
	
	
	public Claims() {
		
	}
	public Claims(String calimID, String custName, String dob, String doadmission, String doDischarge,
			String providerName, Integer billAmt,String memberID,String type) {
		super();
		this.claimID = calimID;
		this.custName = custName;
		this.dob = dob;
		this.doadmission = doadmission;
		this.doDischarge = doDischarge;
		this.providerName = providerName;
		this.billAmt = billAmt;
		this.memberID = memberID;
		this.type=type;
	}
	public String getClaimID() {
		return claimID;
	}
	public void setClaimID(String calimID) {
		this.claimID = calimID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoadmission() {
		return doadmission;
	}
	public void setDoadmission(String doadmission) {
		this.doadmission = doadmission;
	}
	public String getDoDischarge() {
		return doDischarge;
	}
	public void setDoDischarge(String doDischarge) {
		this.doDischarge = doDischarge;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Integer getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Integer billAmt) {
		this.billAmt = billAmt;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
