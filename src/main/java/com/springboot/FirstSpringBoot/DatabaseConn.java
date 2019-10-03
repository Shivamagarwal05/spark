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
			Class.forName("org.postgresql.Driver");
		
		String username = "mhewhozpamnhfu";
			String password = "87456cc5505bf3e6a6f8e32822be8b07887c1397a8169e6fe96fd1e958041c2b";
			String dbUrl = "jdbc:postgresql://ec2-174-129-43-40.compute-1.amazonaws.com:5432/d73rmdvf0amclp?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
				return DriverManager.getConnection(dbUrl, username, password);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 /*
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection(  
				"postgres://mhewhozpamnhfu:87456cc5505bf3e6a6f8e32822be8b07887c1397a8169e6fe96fd1e958041c2b@ec2-174-129-43-40.compute-1.amazonaws.com:5432/d73rmdvf0amclp","mhewhozpamnhfu","87456cc5505bf3e6a6f8e32822be8b07887c1397a8169e6fe96fd1e958041c2b");
		
		} catch (SQLException| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return con;
		
	}

}
