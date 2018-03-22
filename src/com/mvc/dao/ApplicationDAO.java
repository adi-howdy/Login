package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;

public class ApplicationDAO {
	
	public LoginBean getProfile(String user)
	{
		LoginBean user_name = null;
		Connection con = null;
		ResultSet result = null;
		//System.out.println("From application dao" + user);
		try{
		con = DBConnection.createConnection();
		
		String sql = "select * from users where userName = ?";
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setString(1, user);
		result = pr.executeQuery();
		//result = statement.executeQuery("select * from users where userName = ' " + user + "';");
		while(result.next())
		{
			user_name = new LoginBean();
			user_name.setUserName(result.getString("userName"));
			user_name.setPassword(result.getString("password"));			
			user_name.setName(result.getString("Name"));
			user_name.setEmail(result.getString("Email"));
			//String test = user_name.getUserName();
			//System.out.print("inside next loop " + test);
		}
		
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return user_name;
		
	}

}
