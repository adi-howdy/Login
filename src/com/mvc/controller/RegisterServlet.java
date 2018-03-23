package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.LoginBean;
import com.mvc.dao.RegisterDAO;
import com.mvc.util.DBConnection;
import com.mvc.util.Hashing;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name1 = request.getParameter("name");
		String userName1 = request.getParameter("userName");
		String password1 = request.getParameter("password");
		String email1 = request.getParameter("email");
		String role1 = request.getParameter("role");
		
		Hashing hash_password = new Hashing();
		LoginBean bean = new LoginBean();
		
		String hashed = hash_password.generateHash(password1);
		bean.setName(name1);
		bean.setUserName(userName1);
		bean.setPassword(hashed);
		bean.setEmail(email1);
		bean.setRole(role1);
		
		
		
		RegisterDAO register1 = new RegisterDAO();
		String userRegister = register1.register(bean);
		if(userRegister.equals("Success"))
		{
			request.setAttribute("message", "You are successfully Registered "+ name1 + " !!");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else if(userRegister.equals("User exists"))
		{
			request.setAttribute("message", "User already exists");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}	
		
		
	}

}
