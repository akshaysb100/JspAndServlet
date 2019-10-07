/******************************************************************************
 *  Purpose: Connection to database
 *  
 *  @author  Akshay
 *  @version 1.0
 *  @since   20-09-2019
 *
 *******************************************************************************/
package com.bridgelabz.loginregistration.services;

import java.sql.Connection;
import java.sql.DriverManager;

import com.bridgelabz.loginregistration.model.RootPassword;

public class ConnectionProvider implements RootPassword {

	static Connection connection = null;

	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}


