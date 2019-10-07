/******************************************************************************
 *  Purpose: interface
 *  
 *  @author  Akshay
 *  @version 1.0
 *  @since   07-10-2019
 *
 *******************************************************************************/
package com.bridgelabz.loginregistration.model;

public interface StudentDAO {

	public int insertStudent(Student student);
	public Student getStudent(String userName,String password);
}
