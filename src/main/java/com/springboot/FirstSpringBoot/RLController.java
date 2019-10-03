package com.springboot.FirstSpringBoot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RLController
{
	public static Connection con = DatabaseConn.getCon();
	@RequestMapping("/login")
	public ResponseEntity<LoginDetails> login(LoginDetails detail)
	{
		System.out.println(detail.getEmail()+"  "+detail.getPassword());
		try {
			
					//here sonoo is database name, root is username and password  
				
			PreparedStatement ps=con.prepareStatement("select * from users where email=?");
			ps.setString(1, detail.getEmail());
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString("password").equals(detail.getPassword()))
				{
					System.out.println("in");
					//ResponseEntity<LoginDetails> entity = new ResponseEntity<LoginDetails>(HttpStatus.ACCEPTED);
					detail.setPassword(null);
					return ResponseEntity.ok()
			        .header("Custom-Header", "foo")
			        .body(detail);
				}
			}
			
			
				
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
	@RequestMapping("/register")
	public String register(RegisterDetails detail)
	{
		try
		{
			PreparedStatement pst = con.prepareStatement("insert into users values(?,?)");
			pst.setString(1,detail.getEmail());
			pst.setString(2,detail.getPassword());
			pst.execute();
			return "success";
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return e.getSQLState();
		}
		
	
	}
	

}

