 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/style.css"/>">
<script type="text/javascript" src="<c:url value="/resources/validation.js"/>"></script>
<title>Login</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<div class="form"> 
<h1>Login Here</h1>
<h4>${result}</h4>
<form action = "loginProcess"  method="post" modelAttribute = "login">
Email:  <input type = "text" name="email" id="email"/><br><br>
Password:  <input type = "password" name="password" id="password" maxlength="8"/><br><br>
<input class="btncolor" type = "submit" value="Submit"/> 
<input type="button" value="Register" onclick="location.href='register'"  class="btncolor"/> 
</form>
</div>
</body>
</html>

 
