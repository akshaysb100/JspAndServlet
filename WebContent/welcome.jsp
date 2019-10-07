<%@page import="com.bridgelabz.loginregistration.services.ConnectionProvider"%>
<%@page import="com.bridgelabz.loginregistration.model.Student"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>login from ${massage}</h4>
<table border = "1">
  <tr>
    <th>First Name</th>
    <th>last Name</th>
    <th>Mobile Number</th>
    <th>Mail Id</th>
 <!-- <th>Password</th> -->   
  </tr>
    <%
    
    Student student = new Student();

    
	  try {
		  Connection  connection = ConnectionProvider.getConnection();
		  
		
		  PreparedStatement preparedStatement = connection.prepareStatement("select * from 	student");
		  
		  ResultSet rs = preparedStatement.executeQuery();
		
		  while(rs.next()) {
			  /* student.setFirstName(rs.getString(1));
			  student.setLastNmae(rs.getString(2));
			  student.setMobileNumber(rs.getString(3));
			  student.setMailID(rs.getString(4));
			  student.setPassword(rs.getString(5)); */
	%>	
	<tr>
	   <td>
	   <% out.print(rs.getString(1)); %>
	   </td>
	   <td>
	   <% out.print(rs.getString(2)); %>
	   </td>
	   <td>
	   <% out.print(rs.getString(3)); %>
	   </td>
	   <td>
	   <% out.print(rs.getString(4)); %>
	   </td>
	<!--  <td>
	   <% out.print(rs.getString(5)); %>
	   </td> -->  
	</tr>
	
	<%   
			
		  }
		  
		} catch (Exception e) {
			System.out.println(e);
		}
       
    %>
  <tr>
  
</table>
</body>
</html>