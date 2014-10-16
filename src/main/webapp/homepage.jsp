<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebDemo</title>
</head>

<body>
	<h1>Welcome to SpringMVC Demo...</h1>
	<h2>
		<a href="external/viewCRD.jsp">View CRD</a>
	</h2>
	<br>
	<h2>
		<a href="internal/maintainCRD.jsp">Main CRD</a>
	</h2>
	<br>
	<h2>
		<a href="<%=basePath%>">Logout</a>
	</h2>
</body>
</html>