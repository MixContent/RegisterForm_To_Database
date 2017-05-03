package com.khan.hibernate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.khan.hibernate.dao.UserDao;

/**
 * Servlet implementation class UserControllerServlet
 */
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set contentTYpe
		response.setContentType("text/html");
		
		String id=request.getParameter("id");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String qualification=request.getParameter("qualification");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String city=request.getParameter("city");
		
		HttpSession session=request.getSession(true);
		
		try {
			UserDao user=new UserDao();
			user.addUserDetails(id, userName, password, gender, qualification, email, phone, city);
			response.sendRedirect("Sucess");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
