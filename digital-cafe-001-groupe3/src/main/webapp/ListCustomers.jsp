<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List customers</title>
</head>
<body>
	<div align="center">
		<table border="1" cellpadings="5">
			<caption>
				List of Customers
			</caption>
			<tr>
				<th>Number Customer</th>
				<th>Name Customer </th>
				<th>FirstName Contact </th>
				<th>LastName Contact </th>
			</tr>
			<c:forEach var="customer" items="${listCustomers}">
				<tr>
					<td><c:out value="${customer.customerNumber} "/> </td>
					<td><c:out value="${customer.customerName} "/> </td>
					<td><c:out value="${customer.contactFirstName} "/> </td>
					<td><c:out value="${customer.contactLastName} "/> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>