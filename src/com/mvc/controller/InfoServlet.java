package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.ApplicationDAO;

/**
 * Servlet implementation class InfoServlet
 */
//@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		LoginBean loginBean = new LoginBean(); 
		String name = loginBean.getUserName();
		String pwd = loginBean.getPassword();
		
		System.out.print(name);
		System.out.print(pwd);
	     **/
		String userName = (String)request.getSession().getAttribute("userName");
		ApplicationDAO dao = new ApplicationDAO();
		
		//System.out.println(userName);
		
		//System.out.println("First " + userName);
		LoginBean user123 = dao.getProfile(userName);
		//System.out.println("Second" + user123.getUserName());
		
		request.setAttribute("user123", user123);
		
		request.getRequestDispatcher("/Info.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
