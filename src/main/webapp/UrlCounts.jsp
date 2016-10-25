<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<html>
<head>
<%@include file="includes/assets.jsp"%>
<%
	HashMap UrlMap = (HashMap)request.getAttribute("UserUrls");
	HashMap UrlCountsMap = (HashMap)request.getAttribute("userUrlsCount");
	Iterator<String> url =  UrlMap.keySet().iterator(); 
%>
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
				while(url.hasNext()){ 
				String key = (String) url.next();
			%>
					<tr>
						<td><%= key %></td>
						<td><%= UrlMap.get(key) %></td>
						<td><%if(UrlCountsMap.get(UrlMap.get(key)) == null){%><%=0%><%}
						else{%><%= UrlCountsMap.get(UrlMap.get(key)) %><%}%></td>
				<%}%>
		</tbody>
	</table>
</body>
</html>