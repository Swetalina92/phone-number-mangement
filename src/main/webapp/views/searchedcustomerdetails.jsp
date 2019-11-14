<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Searched Customer Details</title>
</head>
<body>

	<h3>Customer Phone Numbers</h3>
	<br>
	<br>
	<br> Customer ID: ${customerdeatils.customerId}
	<br> Customer Name: ${customerdeatils.customerName}
	<br>
	<br>

	<table border='1'>
		<tr>
			<th>Phone Number</th>
			<th>Activation Status</th>
		</tr>

		<c:forEach var="item" items="${customerdeatils.getPhoneList()}">

			<tr>
				<td align="center">${item.key}</td>
				<td align="center">
				<a
					href="http://localhost:8181/updatenumber?phonenumber=${item.key}">
					 ${item.value}
				</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
