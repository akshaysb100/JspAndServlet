<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<form action="loginRegister" method="post">
<table style="background-color: skyblue;margin-left: 20px;margin-left: 20px">
<tr> <h3 style="color: red;">${successMassage}</h3></tr>
<tr>
<td><h3 style="color: red;">${massage}</h3>

<td></td>
</tr>
<tr><td><h3 style="color: red;">Registration Form</h3></td></tr>
<tr><td>First Name</td><td><input type="text" name="firstName" placeholder="Enter first name"></td></tr>
<tr><td>Last Name</td><td><input type="text" name="lastName" placeholder="Enter last name"></td></tr>
<tr><td>Mobile Number</td><td><input type="text" name="mobileNumber"placeholder="Enter moblie number"></td></tr>
<tr><td>Email Id</td><td><input type="text" name="mailId" placeholder="Enter mail_id"></td></tr>
<tr><td>Password</td><td><input type="Password" name="Password1" placeholder="Enter password"></td></tr>
<tr><td>Re-Type Password</td><td><input type="Password" name="Password2" placeholder="Enter re-type password"></td></tr>
<tr><td><input type="submit" name="submit" value="register"></tr>
</table>
</form>
</body>
</html>