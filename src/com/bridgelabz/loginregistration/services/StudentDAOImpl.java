/******************************************************************************
 *  Purpose: database related query
 *  
 *  @author  Akshay
 *  @version 1.0
 *  @since   07-10-2019
 *
 *******************************************************************************/
package com.bridgelabz.loginregistration.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgelabz.loginregistration.model.Student;
import com.bridgelabz.loginregistration.model.StudentDAO;

public class StudentDAOImpl implements StudentDAO {

	static Connection connection;
	static PreparedStatement preparedStatement;
	
	@Override
	public int insertStudent(Student student) {
		
        int status = 0;
        
        try {
			connection = ConnectionProvider.getConnection();
			
			String sqlQuery = "insert into student values(?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(sqlQuery);
			
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastNmae());
			preparedStatement.setString(3, student.getMobileNumber());
			preparedStatement.setString(4, student.getMailID());
			preparedStatement.setString(5, student.getPassword());
			
			status = preparedStatement.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}

	
	@Override
	public Student getStudent(String mailId, String password) {
		
		Student student = new Student();

		  try {
			  connection = ConnectionProvider.getConnection();
			  
			  String sqlQuery = "select * from 	student where  MailId= ? and Password=?";
			  preparedStatement = connection.prepareStatement(sqlQuery);
				
			  preparedStatement.setString(1, mailId);
			  preparedStatement.setString(2, password);
			  
			  ResultSet rs = preparedStatement.executeQuery();
			
			  while(rs.next()) {
				  student.setFirstName(rs.getString(1));
				  student.setLastNmae(rs.getString(2));
				  student.setMobileNumber(rs.getString(3));
				  student.setMailID(rs.getString(4));
				  student.setPassword(rs.getString(5));
			  }
			  
			} catch (Exception e) {
				System.out.println(e);
			}
		return student;
	}

}
