package com.springboot.FirstSpringBoot.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class LoginDetails
{
	public LoginDetails()
	{
		
	}
	public LoginDetails(String email, String password) 
	{
		super();
		this.email = email;
		//this.hashcode = hashcode;
		this.password = password;
	}
	
	private String email;
	@Id
	private String hashcode;
	@Transient
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*public String getHashcode() {
		return hashcode;
	}
	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}*/
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
