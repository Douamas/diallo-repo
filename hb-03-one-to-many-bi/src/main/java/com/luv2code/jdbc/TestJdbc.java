package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {

		 final String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		 final String user = "springstudent";
		 final String pass = "springstudent";
		 
		 try {
			 System.out.println("Connecting to database: "+ jdbcUrl);
			 
			 Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			 
			 System.out.println(myConn);
			 
			 System.out.println("Connection Success ...");
			
		} catch (SQLException e) {
			 System.out.println("Exception ..."+ e);
		}
	}

}
