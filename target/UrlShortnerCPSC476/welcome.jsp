<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<%@include file="includes/assets.inc"%>
</head>
<body>
<h1>Welcome  <%=thisUser.getUsername() %>!!!!!</h1>
<h1>Welcome  <%=thisUser.getEmailID() %>!!!!!</h1>


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