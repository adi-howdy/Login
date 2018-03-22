package com.mvc.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.mvc.util.DBConnection;
import com.mvc.bean.LoginBean;

public class LoginDao {

	public String authenticateUser(LoginBean loginBean)
	 {
		String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
		 String password = loginBean.getPassword();
		
		 Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
		 String userNameDB = "";
		 String passwordDB = "";
		 String roleDB = "";
		 
		 try{

			 con = DBConnection.createConnection(); //establishing connection
			 statement = con.createStatement(); //Statement is used to write queries.
			 resultSet = statement.executeQuery("select userName,password,role from users");
			 while(resultSet.next()) // Until next row is present otherwise it return false
			 {
			 userNameDB = resultSet.getString("userName"); //fetch the values present in database
			 passwordDB = resultSet.getString("password");
			 roleDB = resultSet.getString("role"); 
			 if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Manager"))
			 {
				 con.close();
				 return "Manager"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
			 }
			 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
			 {
				 con.close();
				 return "User";
			 }
		 }
		 }
		 catch (SQLException e)
		 {
			 e.printStackTrace();
			 
		 }
		 return "Invalid user credentials"; // Just returning appropriate message otherwise
	 }
	
	/**
	public LoginBean select(String user1, String pass)
	{
		LoginBean cus = new LoginBean();
		 Connection con1 = null;
		 Statement statement1 = null;
		 ResultSet resultSet1 = null;
		 String userNameDB1 = "";
		 String passwordDB1 = "";
		try{
			 con1 = DBConnection.createConnection(); //establishing connection
			 statement1 = con1.createStatement(); //Statement is used to write queries.
			 resultSet1 = statement1.executeQuery("select userName, password from users where userName = user1");
			 if(resultSet1.next())
			 {
				 cus.setUserName(userName,password);
			 }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return cus;
	}
	
	**/
}
