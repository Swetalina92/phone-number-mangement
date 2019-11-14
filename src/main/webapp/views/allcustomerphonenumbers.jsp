<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Numbers</title>
</head>
<body>
	 <h3> All Customer Phone Numbers </h3><br><br><br>
	<table border='1'>
		<tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Phone Number</th>
			<th>Activation Status</th>
		</tr>

		<c:forEach var="customer" items="${phonelist}">
			<c:forEach var="item" items="${customer.getPhoneList()}">

 <tr>
					<td align="center">${customer.customerId}</td>
					<td align="center">${customer.customerName}</td>
					<td align="center">${item.key}</td>
					<td align="center">${item.value}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>

</body>
</html>
