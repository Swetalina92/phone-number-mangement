<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Name</title>
</head>
<body>
	<c:if test="${error != null}">
		<font color="red"> ${error}</font>
	</c:if>
	<form action="getnumbersbyname" method="post">
		Customer name: <input type="text" name="customerName" required>
		<button type="submit">Click Here</button>
		<br></br>
		<br></br>
	</form>
</body>
</html>