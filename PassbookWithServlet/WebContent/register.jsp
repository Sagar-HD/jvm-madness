<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./register.css">
</head>
<body>
<form class="registerForm" action="register" method="post">
enter account number: <input type="number" name="account_number"/>
enter name: <input type="text" name="name"/>
enter password: <input type="password" name="password"/>
<button type="submit">Register</button>
</form>
<div class="info">
<p>Already have an account</p><a href="index.jsp">Login</a>
</div>
</body>
</html>