<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<%@include file="includes/assets.jsp"%>
<%@ page import="com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails" %>
<%! 
	String userName = "";
	String userEmail = "";
%>
<%
	NewUserDetails thisUser = (NewUserDetails)session.getAttribute("userInsession");

	if(thisUser == null || thisUser.getUsername().equals(null) || thisUser.getUsername().equals("")){
		session.invalidate();
		response.sendRedirect("signUp.jsp");
	}else{
		userName = thisUser.getUsername();
		userEmail = thisUser.getEmailID();
	}
%>
</head>
<body>

	<h3>Welcome ---->>>><%=userName %></h3>
	<h3>Your email is ----->>>><%=userEmail %></h3>
			
		<div class="row col s4">
			<form action="LogOut" method="post">
				<div class="input-field col s6 right">
					<input type="submit" value="Logout">
				</div>
			</form>
		</div>
			
		<div class="row col s4">
			<form action="UrlShortnerServlet" method="post">
				<div class="input-field col s10">
					<input id="longUrl" name="longUrl" type="text"> <label
						for="longUrl">longUrl</label>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input type="submit" value="Short It">
					</div>
				</div>
			</form>
		</div>
</body>
</html>
