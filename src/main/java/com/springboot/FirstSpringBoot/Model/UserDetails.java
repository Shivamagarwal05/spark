package com.springboot.FirstSpringBoot.Model;



import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserDetails 
{
	
	private String firstname;
	private String lastname;
	//private Date dob;
	@Id
	private String email;
	@Transient
	private String password;
	private Timeline usertimeline;
	
	public Timeline getUsertimeline() {
		return usertimeline;
	}
	public void setUsertimeline(Timeline usertimeline) {
		this.usertimeline = usertimeline;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

	

}
