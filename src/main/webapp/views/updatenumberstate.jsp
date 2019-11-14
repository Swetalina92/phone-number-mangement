<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Number</title>
</head>
<body>
	<c:if test="${error != null}">
		<font color="red"> ${error}</font>
	</c:if>
	<form action="updatenumber" method="post">
		Mobile Number: <input type="text" name="phonenumber" required>
		<button type="submit">Activate/Deactivate</button>
		<br></br> <br></br>
	</form>
</body>
</html>