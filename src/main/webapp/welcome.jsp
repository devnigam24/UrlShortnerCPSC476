<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<%@include file="includes/assets.jsp"%>
<%@ page import="com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails" %>
<%! 
	
%>
<%
	String userName = "";
	String userEmail = "";
	String longUrl = (String)request.getAttribute("longUrl");
	String shortUrl = (String)request.getAttribute("shortUrl");
	
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
			<form action="UpdateUrlCountServlet" method="post">
				<input type="hidden" name="action" value="showPage"/>
				<div class="input-field col s6 right">
					<input type="submit" value="View All Urls and its count">
				</div>
			</form>
		</div>
		<div class="row col s4">
			<form action="UrlShortnerServlet" method="post">
				<div class="input-field col s6">
					<input id="longUrl" name="longUrl" type="text" <%if (longUrl != null) %> value=<%=longUrl%>> 
					<label for="longUrl">longUrl</label>
				</div>
				<div class="input-field col s4">
					<a id="shortUrl" onclick="updateClickCount(this)" <%-- href="<%=longUrl %>" target="_blank" --%>>
						<%if (shortUrl != null) %><%=shortUrl %></a>					
				</div>
				<div class="input-field col s4">
					<div class="input-field col s6">
						<input type="submit" value="Short It">
					</div>
				</div>
			</form>
		</div>
		<div id="someID"></div>
</body>
</html>

<script type="text/javascript">
	function updateClickCount(event) {
		$.ajax({
			url : "UpdateUrlCountServlet",
			success : updateUrlCountInHTML,
			error : ajaxErrorFunction,
			dataType : "html",
			data : "action=incrementCount&urlClicked="+event.text.trim(),
			type : "GET"
		}).done(function() {
			console.log("ajax call over successfully");
		});

	}
	function ajaxErrorFunction() {
		alert("ajax error")
	}

	function updateUrlCountInHTML(data) {
		console.log("ajax Success");
		$("#someID").html("");
		$("#someID").html(data);
	}
</script>
