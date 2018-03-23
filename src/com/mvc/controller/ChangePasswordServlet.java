package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.ApplicationDAO;
import com.mvc.util.Hashing;
import com.mvc.util.Validation;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		
		String old_password = request.getParameter("password_old");
		String new_password = request.getParameter("password_new");
		
		HttpSession session = request.getSession();
		String userName1 = (String) session.getAttribute("userName");
		
		Hashing hash = new Hashing();
		ApplicationDAO change = new ApplicationDAO();
		
		String hashed_old_password = hash.generateHash(old_password);
		String hashed_new_password = hash.generateHash(new_password);
		
		Validation val = new Validation();
		String status = val.validatePassword(userName1, hashed_old_password);
		if(status.equals("good"))
		{
			String updated = change.updatePassword(userName1, hashed_new_password);
			if (updated.equals("Success"))
			{
				request.setAttribute("message", "Password Changed successfully");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message", "Sorry, Password could not be changed");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}
		else
		{
			request.setAttribute("message", "Incorrect Password");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		
		
		
	}

}
