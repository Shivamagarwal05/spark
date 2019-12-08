package com.springboot.FirstSpringBoot.Service;

import org.springframework.data.mongodb.repository.Query;

import com.springboot.FirstSpringBoot.Model.LoginDetails;

public interface LoginRepositoryInterface 
{
	
	public void insertLoginCred(LoginDetails logdetails);
	public LoginDetails findByHash(String hash);
	public LoginDetails findByEmail(String email);
	
}
