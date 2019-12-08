package com.springboot.FirstSpringBoot.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.springboot.FirstSpringBoot.Model.UserDetails;
import com.springboot.FirstSpringBoot.Repository.UserRepository;
@Repository
public class UserRepositoryService implements UserRepositoryServiceInterface
{
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return  repository.findOne(email);
	}

	@Override
	public List<UserDetails> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateUser(UserDetails newuser, String email) {
		repository.save(newuser);
		
	}

	@Override
	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUser(UserDetails user) {
		repository.insert(user);
		
	}

	@Override
	public boolean ifUserExists(String email) {
		// TODO Auto-generated method stub
		return repository.exists(email);
	}

	@Override
	public UserDetails getUserByFirstName(String name) {
		// TODO Auto-generated method stub
		return repository.findUserByfirstname(name);
	}
	
	

}
