package com.employee.model;

import javax.persistence.Column;

public class LoginReq {
		
	@Override
	public String toString() {
		return "LoginReq [emailId=" + emailId + ", password=" + password + "]";
	}


	public LoginReq(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
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


	private String emailId;
	
	
	private String password;

}
