<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Records Page</title>
</head>
<body>
${msg}

<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Location</th>
				<th colspan="2">Actions</th>
			</tr>
			<c:forEach items="${friends}" var="friend">
			 <tr>
			 	<td><c:out value="${friend.id}"></c:out></td>
			 	<td><c:out value="${friend.friendName}"></c:out></td>
			 	<td><c:out value="${friend.location}"></c:out></td>
			 	<td>
			 		<a href="delete?id=${friend.id}">Delete</a> 
			 	</td>
			 	<td>
			 		<a href="update?id=${friend.id}">Update</a>
			 	</td>
			 </tr>
			</c:forEach>
		</table>
		
		<a href="">Home</a>
</body>
</html>