package com.springboot.FirstSpringBoot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.springboot.FirstSpringBoot.Model.LoginDetails;
import com.springboot.FirstSpringBoot.Repository.LoginRepository;
@Repository
public class LoginRepositoryService implements LoginRepositoryInterface,UserDetailsService
{
	@Autowired
	LoginRepository loginrepo;
	
	@Override
	public LoginDetails findByHash(String hash)
	{
		
		return loginrepo.findOne(hash);
	}
	@Override
	public void insertLoginCred(LoginDetails logdetails) {
		loginrepo.insert(logdetails);
		
	}
	@Override
	public LoginDetails findByEmail(String email) {
		// TODO Auto-generated method stub
		return loginrepo.findUserByemail(email);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
