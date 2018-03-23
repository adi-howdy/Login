<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
</head>
<body>
<%=session.getAttribute("userName") %>
 <ul>
 <li><a href="Home.jsp">Home</a></li>
 <li><a href="#">Profile</a>
 <ul>
 	<li><a href="InfoServlet">View Profile</a></li>
 	<li><a href="Change_password.jsp">Change Password</a></li>
 </ul>
 </li>
 <li><a href="Dayoff.jsp">Dayoff Application</a></li>
 <li><a href="#">Notification</a>
 <ul>
 <li><a href="Training.jsp">Training</a></li>
   <li><a href="News.jsp">News</a></li>
 </ul>
 </li>
 <li><a href="#">About</a>
 <ul>
   <li><a href="Employer.jsp">Our Team</a></li>
   <li><a href="Policy.jsp">Company Policy</a></li>
   <li><a href="Mission.jsp">Mission &amp; Vision</a></li>
   <li><a href="Company.jsp">Company Info</a></li>
  </ul>
  </li>
 <li><a href="LogoutServlet">Logout</a></li>
 </ul>
<p>${message}<p>
</body>
</html>