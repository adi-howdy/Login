package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;

public class RegisterDAO {

	Connection con = null;
	PreparedStatement result = null;
	
	public String register(LoginBean user)
	{
		String name2 = user.getName();
		String userName2 = user.getUserName();
		String password2 = user.getPassword();
		String email2 = user.getEmail();
		String role2 = user.getRole();
		String status = null;
		try{
			con = DBConnection.createConnection();
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
		catch (SQLException e)
		{
			System.out.print(e);
		}
		return status;
	}
	
}
