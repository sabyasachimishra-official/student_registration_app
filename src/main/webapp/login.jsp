<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
<h2>login here...</h2>
<form action="verifylogin" method="post">

EMAIL:<input type="text" name="email"/>
PASSWORD:<input type="text" name="password"/>
<input type="submit" value="Login"/>

<div>
<%
if(request.getAttribute("error")!=null)
{
	out.println(request.getAttribute("error"));
}

%>
</div>

</form>
</body>
</html>