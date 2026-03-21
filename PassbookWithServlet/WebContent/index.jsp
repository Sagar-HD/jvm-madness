<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./index.css">
</head>
<body>
<form class="loginForm" action="login" method="post">
enter name: <input type="text" name="name"/>
enter password: <input type="password" name="password"/>
<button type="submit">Login</button>
</form>
<div class="info">
<p >Don't have an account</p><a href="register.jsp">Register</a>
</div>
</body>
</html>