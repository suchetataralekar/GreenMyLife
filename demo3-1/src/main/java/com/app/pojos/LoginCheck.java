package com.app.pojos;

import org.springframework.stereotype.Component;


public class LoginCheck {

	private String email;
	private String password;
	
	public LoginCheck() {
		// TODO Auto-generated constructor stub
	}

	public LoginCheck(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginCheck [email=" + email + ", password=" + password + "]";
	}

	
	
	
	
	}
