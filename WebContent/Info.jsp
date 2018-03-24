<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Info Details</title>
</head>
<body>
	<table align="center" style= "background-color: skyblue">
	<tr>
	<td>User Name</td>
	<td>${user123.userName}</td>
	</tr>
	<tr>
	<td>Name</td>
	<td>${user123.name}</td>
	</tr>
	<tr>
	<td>Email</td>
	<td>${user123.email}</td>
	</tr>
	<tr>
	<td>Role</td>
	<td>${user123.role}</td>
	</tr>
	</table>
	<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
	<table>
	<tr>
	<td>Image Link:</td>
	<td><input type="file" name="file"></td>
	</tr>
	<tr>
	<td>
	</td>
	<td><input type="submit" value="submit"></td>
	</tr>
	</table>
	
	</form>
</body>
</html>