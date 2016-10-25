<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<html>
<head>
<%@include file="includes/assets.jsp"%>
<%
	HashMap UrlMap = (HashMap)request.getAttribute("UserUrls");
	HashMap UrlCountsMap = (HashMap)request.getAttribute("userUrlsCount");
%>
${UrlMap}
</head>
<body>
	<table>
		<thead>
			<tr>
				<th data-field="longUrl">Long Url</th>
				<th data-field="ShortUrl">Short Url</th>
				<th data-field="urlCount">Hits</th>
			</tr>
		</thead>

		<tbody>
			<% 
				Iterator<String> i =  UrlMap.keySet().iterator(); 
				while(i.hasNext()){ String key = (String) i.next();%>
					<tr>
						<td><%= key %></td>
						<td><%= UrlMap.get(key) %></td>
						<td>$0.87</td>
					</tr>
				<%}%>
		</tbody>
	</table>
</body>
</html>