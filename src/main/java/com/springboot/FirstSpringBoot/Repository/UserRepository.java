package com.springboot.FirstSpringBoot.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.FirstSpringBoot.Model.UserDetails;

public interface UserRepository extends MongoRepository<UserDetails,String> 
{

	public UserDetails findUserByfirstname(String name);

}
