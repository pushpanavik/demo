<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
<script type="text/javascript" src="<c:url value="/resources/validation.js"/>"></script> 
<title>Register</title>
</head>
<body>
<div class="form"> 
<form action="registerProcess" method="post" modelAttribute ="user">

<h1>Registration</h1>
Username: <input type="text" name="name" id="name"/><br><br>

Password: <input type="text" name="password" id="password" maxlength="8"/><br><br>

Email: <input type="text" name="email" id="email"/><br><br>

City: <input type="text" name="city" id="city"/><br><br>

<input class="btncolor" type="submit" value="Register" onclick="return validateRegister()"> 
<p>${message}</p>

</form>
</div>
</body>
</html>
