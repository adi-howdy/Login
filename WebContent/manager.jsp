<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Home</title>
</head>
<body>
<center><h2>Home Page</h2></center>
 <!--  
 Welcome <%=request.getAttribute("userName") %> <!-- Refer to the video to understand how this works -->
 <table id = "profile">
 <tr>
 <td></td>
 <td><%=session.getAttribute("userName") %></td>
 </tr>
  <tr>
 <td>>${message}</td>
 </tr>
 </table>
 <div style="text-align: right"><a href="LogoutServlet">Logout</a></div>
 <div style="text-align: left"><a href="InfoServlet">Info</a></div>
  <div style="text-align: left"><a href="Dayoff.jsp">Vacation/Dayoff Report</a></div>
</body>
</html>