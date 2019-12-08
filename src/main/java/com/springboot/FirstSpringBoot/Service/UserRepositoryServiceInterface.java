package com.springboot.FirstSpringBoot.Service;

import java.util.List;


import com.springboot.FirstSpringBoot.Model.UserDetails;

public interface UserRepositoryServiceInterface 
{
	public UserDetails getUserByEmail(String email);
	public List<UserDetails> getAllUsers();
	public UserDetails getUserByFirstName(String name);
	public void updateUser(UserDetails newuser,String email);
	public void deleteUser(String email);
	public void insertUser(UserDetails user);
	public boolean ifUserExists(String email);

}
