<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet"	href="css/mystyle.css" />
<script> 
function validate()
{ 
 var username = document.form.username.value; 
 var password = document.form.password.value;
 
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(password==null || password=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 } 
}
</script> 
</head>
<body>
<div style="text-align:center"><h1> Welcome </h1> </div>
<br>
<form name="form" class="loginform group" action="LoginServlet" method="post" onsubmit="return validate()">
<table>
<tr><td>${message}</td></tr>
</table>
<h2>Login</h2> 
<p>Sign in Login to Employee Portal</p>
<label for="myname">Username</label>
<input type="text" name="username" id="myname" />
<label for="mypassword">Password</label>
<input type="password" name="password" id="mypassword" />
<table>
 <tr> <!-- refer to the video to understand request.getAttribute() -->
 <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></span></td>
 </tr>
</table>
<input type="submit" value="Login"></input>
<a href="Register.jsp">Register</a>
</form>
 
</body>
</html>