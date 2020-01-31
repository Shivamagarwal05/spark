package com.springboot.FirstSpringBoot.Controller;
import java.io.ObjectInputStream.GetField;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.FirstSpringBoot.Model.Event;
import com.springboot.FirstSpringBoot.Model.LoginDetails;
import com.springboot.FirstSpringBoot.Model.Timeline;
import com.springboot.FirstSpringBoot.Model.UserDetails;
import com.springboot.FirstSpringBoot.Service.LoginRepositoryService;
import com.springboot.FirstSpringBoot.Service.UserRepositoryService;



@RestController
public class UserController 
{
	@Autowired
	UserRepositoryService registerreposervice;
	@Autowired
	LoginRepositoryService loginreposervice;
	@PostMapping(path="/login")
	public ResponseEntity<String> userLogin(@RequestBody LoginDetails detail)
	{
		System.out.println(detail.getEmail()+"  "+detail.getPassword());
		
			String email = detail.getEmail();
			String temp = email +"shivam"+detail.getPassword();
			String hashcode	= Base64.getEncoder().encodeToString(temp.getBytes());
			
			
			//reposervice.insertUser(user);
			
			LoginDetails loguser= loginreposervice.findByHash(hashcode);
			LoginDetails loguser1= loginreposervice.findByEmail(email);
			System.out.println(loguser+"   "+loguser);
			//System.out.println(loguser1.getEmail()+" "+loguser.getHashcode()+" "+loguser.getPassword());
			if(loguser!=null)
			{
				HttpHeaders headers = new HttpHeaders();
				System.out.println();
				headers.add("Auth-Code",hashcode);
				return new ResponseEntity<String>("Succesfully logged in",headers,HttpStatus.OK);
				
			
			}
			
			else
			{
				return new ResponseEntity<String>("Wrong Credentials",HttpStatus.FORBIDDEN);
		
			}
		 
	}
	@PostMapping(path="/register")
	public ResponseEntity<String> userRegister( UserDetails detail)
	{
		//System.out.println(detail.getEmail()+"  "+detail.getPassword());
		
			String temp = detail.getEmail()+"shivam"+detail.getPassword();
			String hashcode	= Base64.getEncoder().encodeToString(temp.getBytes());
			
			//reposervice.insertUser(user);
			if(!registerreposervice.ifUserExists(detail.getEmail()))
			{
				Timeline t= new Timeline();
				List<Event> list = new ArrayList<Event>();
				t.setEvent(list);
				detail.setUsertimeline(t);
				registerreposervice.insertUser(detail);
				loginreposervice.insertLoginCred(new LoginDetails(detail.getEmail(), hashcode, detail.getPassword()));
				
				HttpHeaders headers = new HttpHeaders();

				return new ResponseEntity<String>("Succesfully Registered",headers,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Failed",HttpStatus.ALREADY_REPORTED);
				
				
			}
			//System.out.println();
			
				
		
		
		 
	}
	@PostMapping(path="/dashboard")
	public ResponseEntity<UserDetails> getDash(@RequestHeader("Auth-Code") String hashcode)
	{
		
		 	//System.out.println("%%%%%%%%%%%%%%%***"+authcode);
			LoginDetails user= loginreposervice.findByHash(hashcode);
			System.out.println(user.toString());
			UserDetails userdata=registerreposervice.getUserByEmail(user.getEmail());
			UserDetails userdata1 = registerreposervice.getUserByFirstName(userdata.getFirstname());
			System.out.println(userdata1.getEmail()+" "+userdata1.getFirstname()+" "+userdata1.getLastname()+" "+userdata1.getPassword());
			if(userdata!=null)
			{
				
				return new ResponseEntity<UserDetails>(userdata,HttpStatus.OK);
				
			
			}
			
			else
			{
				return new ResponseEntity<UserDetails>(userdata,HttpStatus.NOT_FOUND);
		
			}
		 
	}
	@PostMapping(path="/add")
	public void add(String email,String desc)
	{
		System.out.println(email);
		UserDetails userdata=registerreposervice.getUserByEmail(email);
		Event e = new Event();
		System.out.println("hi");
		Date date = new Date();
		e.setEventdate(date);
		e.setEventdesc(desc);
		e.setEventtime(LocalTime.now());
	//	List<Event> events = new ArrayList<Event>();
		userdata.getUsertimeline().getEvent().add(e);
		//Timeline t = new Timeline();
		//t.setEvent(events);
	//	userdata.setUsertimeline(t);
		registerreposervice.updateUser(userdata,email);
		
		
		
		
		
	}
	@PostMapping(path="/logout")
	public void logoutcont(@RequestHeader("cookiename") String cname,HttpServletResponse response)
	{
		System.out.println("@@@@@@@@@@@@@@"+cname);
		Cookie cookie = new Cookie(cname, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		
	}
	

}
