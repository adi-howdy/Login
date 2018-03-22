package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.DayoffBean;
import com.mvc.bean.LoginBean;
import com.mvc.dao.ApplicationDAO;
import com.mvc.dao.DayoffDAO;

/**
 * Servlet implementation class DayoffServlet
 */
@WebServlet("/DayoffServlet")
public class DayoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DayoffServlet() {
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
		String reason1 = request.getParameter("reason");
		String from1 = request.getParameter("from");
		String to1 = request.getParameter("to");
		HttpSession session = request.getSession();
		String userName1 = (String) session.getAttribute("userName");
		//LoginBean userName2 = new LoginBean();
		ApplicationDAO dao = new ApplicationDAO();
		LoginBean user123 = dao.getProfile(userName1);
		DayoffDAO dayoffDAO = new DayoffDAO();
		DayoffBean bean = new DayoffBean();
		bean.setReason(reason1);
		bean.setFrom(from1);
		bean.setTo(to1);
		String status = dayoffDAO.dayOff(user123, bean);
		if(status.equals("Success"))
		{
			request.setAttribute("message", "You have successfully applied for vacancy/dayoff");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		
		
		
	}

}
