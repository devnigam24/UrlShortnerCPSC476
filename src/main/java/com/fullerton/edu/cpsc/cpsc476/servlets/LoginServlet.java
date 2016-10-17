package com.fullerton.edu.cpsc.cpsc476.servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String userName = "" , password="";
		if(request.getParameter("loginName") != "" && request.getParameter("loginName") != null)
			userName = request.getParameter("loginName");
		if(request.getParameter("loginPwd") != "" && request.getParameter("loginPwd") != null)
			password = request.getParameter("loginPwd");
		
		checkLoginCredentials(userName,password);
	}

	private void checkLoginCredentials(String userName, String password) {
		
	}

}
