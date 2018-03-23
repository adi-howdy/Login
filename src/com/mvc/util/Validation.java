package com.mvc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validation {
	
	Connection con = null;
	ResultSet result = null;
	
	public String userNameValidation(String userName1)
	{
		String status ="good";
		try{
		con = DBConnection.createConnection();
		String sql = "select * from users where userName = ?";
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setString(1, userName1);
		result = pr.executeQuery();
		while(result.next())
		{
			if(result.getString("userName").equals(userName1))
			{
				status = "User exists";
				
			}
			
		}
		
		}
		catch (SQLException e)
		{
			System.out.print(e);
		}
		
		return status;
	}
	
	public String validatePassword(String uname, String pass)
	{
		String status = "bad";
		con = DBConnection.createConnection();
		try{
			String sql = "select * from users where userName = ?";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, uname);
			result = pr.executeQuery();
			while(result.next())
			{
				if(result.getString("password").equals(pass))
				{
					status = "good";
				}
			}
		}
		catch (SQLException e)
		{
			System.out.print(e);
		}
		return status;
	}

}
