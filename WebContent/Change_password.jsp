<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet"	href="css/mystyle.css" />
</head>
<body>
<form name = "form" class="loginform group" action="ChangePasswordServlet" method="post" onsubmit="return validate()">
	<label for="current">Current Password:</label>
	<input type="password" name="password_old" id="password_old"/>
	<label for="new">New Password :</label>
	<input type="password" name="password_new" id="password_new"/>
	<input type="submit" name="submit" value="Change Password"></input>
	</form>
</body>
</html>