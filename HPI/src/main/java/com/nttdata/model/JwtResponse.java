package com.nttdata.model;

public class JwtResponse {
	
	String token;
	
	public JwtResponse(String token) {
		
		this.token = token;
	}

	public JwtResponse() {
		super();
	}
	
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	


	
	

}
