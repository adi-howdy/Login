<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<!--  link rel="stylesheet" href="css/normalize.css" /> -->
<link rel="stylesheet"	href="css/mystyle.css" />
<script>
function validate()
{
	var name1 = document.form.name.value;
	var userid1 = document.form.username.value;
	var password1 = document.form.password.value;
	var email1 = document.form.email.value;
	var role1 = document.form.role.value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (name1==null || name1=="")
	 { 
	 alert("Name cannot be blank"); 
	 return false; 
	 }
	else if (userid1==null || userid1=="")
	 { 
	 alert("UserID cannot be blank"); 
	 return false; 
	 }
	 else if (password1==null || password1=="" || password1.length < 8)
	 { 
	 alert("Invalid Password"); 
	 return false; 
	 }
	 else if (role1 == "Choose..")
	 {
		 alert("Choose correct role")
		 return false;
	 }
	 else if (email1.match(mailformat) && email1 != null && email1 != "")
		{
		 return true;
		}
	 else 
		 {
		 alert("Invalid Email address");
		 return false;
		 }
	
	
}
</script>
</head>
<body>
<form name = "form" class="loginform group" action="RegisterServlet" method="post" onsubmit="return validate()">
	<label for="name">Name:</label>
	<input type="text" name="name" id="name"/>
	<label for="username">UserName :</label>
	<input type="text" name="userName" id="username"/>
	<label for="password">Password :</label>
	<input type="password" name="password" id="password"/>
	<label for="email">Email :</label>
	<input type="text" name="email" id="email"/>
	<label for="role">Role:</label>
 	<select name="role" id="role">
 	<option>Choose..</option>
 	<option value="Manager">Manager</option>
 	<option value="User">User</option>
 	</select>
	<input type="submit" name="submit" value="Sign Up"></input>
	</form>
</body>
</html>