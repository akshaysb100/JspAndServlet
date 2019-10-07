/******************************************************************************
 *  Purpose: Access data form database or insert into database
 *  
 *  @author  Akshay
 *  @version 1.0
 *  @since   07-10-2019
 *
 *******************************************************************************/
package com.bridgelabz.loginregistration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.loginregistration.model.Student;
import com.bridgelabz.loginregistration.model.StudentDAO;
import com.bridgelabz.loginregistration.services.CheckValues;
import com.bridgelabz.loginregistration.services.StudentDAOImpl;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO studentDAO = new StudentDAOImpl();
		
		String mailId = request.getParameter("mailId");
		String password = request.getParameter("Password1");
		String submitType = request.getParameter("submit");
		
		Student student = new Student(); 
		student = studentDAO.getStudent(mailId, password);
		
		if(submitType.equals("login") && student!=null && student.getMailID()!=null ) {
		    //name of user
			System.out.println("name : "+student.getFirstName());
			
			request.setAttribute("massage", mailId);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if (submitType.equals("register")) {
			
			String firstName = request.getParameter("firstName");
			 String lastName = request.getParameter("lastName");
			 String mobileNumber = request.getParameter("mobileNumber");
			 String reTypePassword = request.getParameter("Password2");
			 int count = 0;
			 while(true) {
				 
				 String flag = CheckValues.checkValue(firstName,lastName,mobileNumber,mailId,password,reTypePassword);
					
				 
				 if(flag == "yes") {
					 student.setFirstName(firstName);
					 student.setLastNmae(lastName);
					 student.setMobileNumber(mobileNumber);;
					 student.setMailID(mailId);
					 student.setPassword(password);
					 studentDAO.insertStudent(student);
					 //System.out.println(student.getFirstName());
					 request.setAttribute("successMassage", "Registation is done, Please login to continue !!!");
					 request.getRequestDispatcher("login.jsp").forward(request, response);
					 
					 break;
				 }else{
					 request.setAttribute("successMassage", "wrong input !!!\n"+flag);
					 request.getRequestDispatcher("register.jsp").forward(request, response);
				 }
				 
				
			 }
			 
			
		}else {
			request.setAttribute("massage", "Data not found ,click on Register !!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
