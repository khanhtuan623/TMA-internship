<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Device</title>
</head>
<body>
	<h1>Device Form Edit</h1>
	<hr />
	<form:form action="/Edit-Save" method="POST" modelAttribute="device">
		<table>
		<tr>
		<td></td>
		<td> <form:hidden path="id"/> </td>
		</tr>
			<tr>
				<td>Brand:</td>
				<td><form:input  path="brand"/></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input  path="name" /></td>
			</tr>
			<tr>
				<td>Color:</td>
				<td><form:input path="color" /></td>
			</tr>
			<tr>
				<td>Memory:</td>
				<td><form:input path="memory" /></td>
			</tr>
			<tr>
				<td>Infor:</td>
				<td><form:input type="textarea" path="infor" /></td>
			</tr>
			<tr>
				<td>Qty:</td>
				<td><form:input  path="quantity" /></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><form:input path="status" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Image:</td>
				<td><form:input path="image" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save Edit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>