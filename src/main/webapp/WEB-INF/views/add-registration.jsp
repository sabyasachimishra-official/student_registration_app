<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
<h2>Add Registration.....</h2>
<form action="addreg" method="post">
<pre>
Name:  <input type="text" name="name"/>
Course:  <input type="text" name="course"/>
Email: <input type="text" name="email"/>
Mobile:<input type="text" name="mobile">
<input type="submit" value="save"/>
</pre>
</form>
</body>
</html>