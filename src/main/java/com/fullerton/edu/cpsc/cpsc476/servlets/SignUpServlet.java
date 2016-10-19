package com.fullerton.edu.cpsc.cpsc476.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fullerton.edu.cpsc.cpsc476.Util.DAOUtil;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;

@WebServlet(
			name="SignUpServlet",
			urlPatterns = {"/SignUpServlet"}
		)
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String username = "", password = "", confirm = "", email = "";
		if (req.getParameter("username") != null && req.getParameter("username") != "") {
			username = req.getParameter("username");
		}
		if (req.getParameter("password") != null && req.getParameter("password") != "") {
			password = req.getParameter("password");
		}
		if (req.getParameter("cpassword") != null && req.getParameter("cpassword") != "") {
			confirm = req.getParameter("cpassword");

		}
		if (req.getParameter("email") != null && req.getParameter("email") != "") {
			email = req.getParameter("email");
		}		
		if (password.equals(confirm)) {
			try {
				NewUserDetails newUser = new NewUserDetails(username, email, password);
				Boolean isDataStored = DAOUtil.storeUserInDB(req, res, newUser);
				if(isDataStored){
					HttpSession session = req.getSession();
					session.setAttribute("userInsession", newUser);
					req.getRequestDispatcher("welcome.jsp").forward(req, res);
				}
			} catch (ServletException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			req.setAttribute("name", username);
			req.setAttribute("email", email);
			req.setAttribute("passwordDonotMatch", "true");
			try {
				req.getRequestDispatcher("signUp.jsp").forward(req, res);
			} catch (ServletException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}
