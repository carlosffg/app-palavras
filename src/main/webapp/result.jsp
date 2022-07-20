<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado</title>
</head>
<body>
	<% out.print(request.getAttribute("palavra")); %>
	<% out.print(request.getAttribute("result")); %>
</body>
</html>