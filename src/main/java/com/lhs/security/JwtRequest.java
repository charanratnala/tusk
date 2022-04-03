package com.lhs.security;

public class JwtRequest {

	String password;

	String username;

	public JwtRequest() {
		super();
	}

	public JwtRequest(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
