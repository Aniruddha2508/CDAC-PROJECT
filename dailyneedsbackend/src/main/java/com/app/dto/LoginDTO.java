package com.app.dto;

public class LoginDTO {
	String email;
	String Password;
	
	
	public LoginDTO() {
		super();
	}
	public LoginDTO(String email, String password) {
		super();
		this.email = email;
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

}
