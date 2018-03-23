package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;
import com.mvc.util.Validation;

public class RegisterDAO {

	Connection con = null;
	PreparedStatement result = null;
	ResultSet result1 = null;
	
	public String register(LoginBean user)
	{
		String name2 = user.getName();
		String userName2 = user.getUserName();
		String password2 = user.getPassword();
		String email2 = user.getEmail();
		String role2 = user.getRole();
		String status = null;
		Validation val = new Validation();
		try{
			con = DBConnection.createConnection();
			
			String user_status = val.userNameValidation(userName2);
			
			if(user_status.equals("User exists"))
			{
				status = "User exists";
				
			}
			else if(user_status.equals("good")){
			result = con.prepareStatement("insert into users values(?,?,?,?,?)");
			result.setString(1, name2);
			result.setString(2, userName2);
			result.setString(3, password2);
			result.setString(4, email2);
			result.setString(5, role2);
			result.executeUpdate();
			con.close();
			status = "Success";
			}
		}
		catch (SQLException e)
		{
			System.out.print(e);
		}
		return status;
	}
	
}
