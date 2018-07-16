<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='<c:url value="/resources/css/Infor.css" />'  rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INFORMATION</title>
</head>
<body>
<div id="main">
<div id="index-1" class="index"></div>
<div id="index-2" class="index">
	<form:form action="/Check-Payment" method="POST"
		modelAttribute="inforPayment">
		<table>
			<h1>INFORMATION</h1>
				<tr>
					<td>NAME:</td>
					<td><form:input value="TRAN KHANH TUAN" path="name" required="required" /></td>
				</tr>
				<tr>
					<td>PHONE:</td>
					<td><form:input value="0987654321" path="phone" required="required"/></td>
				</tr>
				<tr>
					<td>EMAIL:</td>
					<td><form:input value="khanhtuan623@gmail.com" path="email" required="required"/></td>
				</tr>
				<tr>
					<td>ADDRESS:</td>
					<td><form:input value="District 7" path="address" required="required"/></td>
				</tr>
				<tr>
					<td>NAME CARD:</td>
					<td><form:input value="TRAN KHANH TUAN" path="nameCard" required="required"/></td>
				</tr>
				<tr>
					<td>NUMBER CARD:</td>
					<td><form:input value="1234123412341234" path="numberCard" required="required"/></td>
				</tr>
				<tr>
					<td>SECURITY CODE:</td>
					<td><form:input value="1234" path="securityCard" required="required"/></td>
				</tr>
				<tr>
					<td>EXP_DATE:</td>
					<td><form:input value="02/2222" path="expDate" required="required"/></td>
				</tr>
				<tr>
				<td></td>
				<td> <form:hidden path="idDevice" value="${device.id}"/> </td>
				</tr>
				<tr>
					<td>BRAND:</td>
					<td><form:input class="hidden" path="brandDevice" value="${device.brand}" readonly="true" /></td>
				</tr>
				<tr>
					<td>DEVICE:</td>
					<td><form:input class="hidden" path="nameDevice" value="${device.name }"  readonly="true"/></td>
				</tr>
				<tr>
					<td>COLOR:</td>
					<td><form:input class="hidden" path="colorDevice" value="${device.color}" readonly="true"/></td>
				</tr>
				<tr>
					<td>MEMORY:</td>
					<td><form:input class="hidden" path="memoryDevice" value="${device.memory}" readonly="true" /></td>
				</tr>
				<tr>
				<td></td>
				<td> <form:hidden path="qty" value="${device.quantity}"/> </td>
				</tr>
				<tr>
					<td>PRICE:</td>
					<td><form:input class="hidden" path="price" value="${device.price}" readonly="true" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Payment" /></td>
				</tr>
		</table>
	</form:form>
	</div>
	</div>
</body>
</html>