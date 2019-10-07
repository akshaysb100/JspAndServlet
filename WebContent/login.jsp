<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body >

<form action="loginRegister" method="post">

<table style="background-color: skyblue;margin-left: 20px;margin-left: 20px;">

<tr><td><h3 style="color: red;">${massage}</h3>
<h3 style="color: red;">${successMassage}</h3>
</td></tr>
<tr><td><h3 style="color: red;">Login Page</h3></td></tr>
<tr><td>Email</td><td><input type="text" name="mailId" placeholder="Enter mail_id"></td></tr>
<tr><td>Password</td><td><input type="Password" name="Password1" placeholder="Enter password"></td></tr>
<tr><td><input type="submit" name="submit" value="login"></td><td><a href="register.jsp">Registration</a></td></tr>

</table>

</form>

</body>
</html>