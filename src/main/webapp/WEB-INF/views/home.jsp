<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");  %>
<h1> XYZ Company. <span><input type="button" value="Logout" onclick="location.href='logout'"  class="btncolor floating"/> </span></h1>

<hr>
<div class="form">	
<h3>DETAILS</h3>
<hr>
<table>
  <tr>
    <th>Name:</th>
    <td>${username}</td>
  </tr>
  <tr>
    <th>Email:</th>
    <td>${email}</td>
  </tr>
  <tr>
    <th>City:</th>
    <td>${city}</td>
  </tr>
</table>
</div>

</body>
</html>
