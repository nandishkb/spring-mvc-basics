<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Records Page</title>
</head>

<body>
	Page: ${msg}

	<form:form action="saveFriend" method="POST">
		<table>
			<tr>
				<td>Id:</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><form:input path="friendName" /></td>
			</tr>
			<tr>
				<td>Location:</td>
				<td><form:input path="location" /></td>
			</tr>
			<tr>
				<td><input type="submit" /></td>
			</tr>


		</table>
	</form:form>



	<a href="">Home</a>

</body>

</html>