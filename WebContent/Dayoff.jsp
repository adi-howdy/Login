<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Day-off/Vacation Application</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">

 <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<!--   <link rel="stylesheet" href="css/normalize.css" /> -->
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <script>
 $( function() {
   $( "#datepicker" ).datepicker();
 } );
</script>
 <script>
 $( function() {
   $( "#datepicker1" ).datepicker();
 } );
</script>
<script>
function validate()
{
	var reason1 = document.form.reason.value;
	var from1 = document.form.from.value;
	var to1 = document.form.to.value;
	if(reason1 == "Choose..")
	{
	alert("Choose correct reason");
	return false;
	}
	else if(from1 == null || from1 == "")
	{
	alert("Choose Correct date");
	return false;
	}
	else if(to1 == null || to1 == "")
	{
	alert("Choose Correct date");
	return false;
	}
	else if(from1 > to1)
	{
	alert("Choose Correct date");
	return false;
	}
}
</script>
</head>
<body>
<ul>
 <li><a href="Home.jsp">Home</a></li>
 <li><a href="InfoServlet">Profile</a></li>
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
<div style="text-align:center"><h1> Day-off/Vacation Application </h1> </div>
<br>
<form name="form" action="DayoffServlet" method="post" onsubmit="return validate()">
<table align="center" style= "background-color: #7A1631" >
<tr>
 <td>Reason:</td>
 <td>
 <select name="reason">
 	<option>Choose..</option>
 	<option value ="Vacation">Vacation</option>
 	<option value = "Sick Leave">Sick Leave</option>
 	<option value = "Other">Other</option>
 </select>
 </td>
 </tr>
 <tr>
 <td>From: <input type="text" id="datepicker" name="from"></td>
 </tr>
 <tr>
 <td>To: <input type="text" id="datepicker1" name="to"></td>
 </tr>
 <tr>
 	<td><input type="submit" name="submit" value="Apply" ></td>
 </tr>
</table>
</form>
</body>
</html>