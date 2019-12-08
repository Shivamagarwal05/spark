package com.springboot.FirstSpringBoot.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.FirstSpringBoot.Model.LoginDetails;

public interface LoginRepository extends MongoRepository<LoginDetails,String>
{
	public LoginDetails findUserByemail(String email);

}
