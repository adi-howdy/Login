package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.DayoffBean;
import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;

public class DayoffDAO {
	Connection con = null;
	PreparedStatement result = null;
	String status = null;
	
	public String dayOff(LoginBean bean, DayoffBean vacation)
	{
		try{
			con =  DBConnection.createConnection();
			result = con.prepareStatement("insert into dayoff values(?,?,?,?)");
			result.setString(1, bean.getUserName());
			result.setString(2, vacation.getReason());
			result.setString(3, vacation.getFrom());
			result.setString(4, vacation.getTo());
			result.executeUpdate();
			con.close();
			status = "Success";
		}
		catch(SQLException e)
		{
			System.out.print(e);
		}
		return status;
	}
	

}
