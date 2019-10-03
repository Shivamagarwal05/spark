package com.springboot.FirstSpringBoot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn
{
	public static Connection getCon()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/inter","root","");
		
		} catch (SQLException| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
