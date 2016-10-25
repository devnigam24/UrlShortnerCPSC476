package com.fullerton.edu.cpsc.cpsc476.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;

/**
 * Servlet implementation class UrlShortnerServlet
 */
public class UrlShortnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SecureRandom randomString = new SecureRandom();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession thisSession = request.getSession();
		NewUserDetails userObject = (NewUserDetails) thisSession.getAttribute("userInsession");
		String longUrl = request.getParameter("longUrl");
		String shortUrl = "";
		for (String oneUrl : userObject.getUrlShornerMap().keySet()) {
			if (oneUrl.equalsIgnoreCase(longUrl)) {
				shortUrl = userObject.getUrlShornerMap().get(oneUrl);
			}
		}
		if (shortUrl.equals("")) {
			shortUrl = "http://" + request.getServerName() + ":" + request.getLocalPort() + "/"
					+ request.getContextPath() + "/" + new BigInteger(30, randomString).toString(32);
		}
		userObject.getUrlShornerMap().put(longUrl, shortUrl);
		request.setAttribute("longUrl", longUrl);
		request.setAttribute("shortUrl", shortUrl);
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
