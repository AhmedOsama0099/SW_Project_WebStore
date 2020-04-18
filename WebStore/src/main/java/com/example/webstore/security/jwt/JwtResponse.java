package com.example.webstore.security.jwt;

import java.util.List;

public class JwtResponse {
	private String token;
	private String username;
	private String email;

	public JwtResponse(String accessToken, String username, String email) {
		this.token = accessToken;
		this.username = username;
		this.email = email;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}






	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
