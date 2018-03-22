package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection createConnection()
	{
	Connection con = null;
	String url = "jdbc:sqlserver://DESKTOP-FGEKG1F\\SQLEXPRESS_2016; databaseName=learn;integratedSecurity=true"; //MySQL URL and followed by the database name
	try 
	{
	try 
	{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //loading mysql driver 
	} 
	catch (ClassNotFoundException e)
	{
	e.printStackTrace();
	} 
	con = DriverManager.getConnection(url); //attempting to connect to MySQL database
	System.out.println("Printing connection object "+con);
	} 
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	return con; 
	}

}
