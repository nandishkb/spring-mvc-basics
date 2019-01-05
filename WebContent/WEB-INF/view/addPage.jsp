<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "core" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fo" uri="http://www.springframework.org/tags/form"  %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Records Page</title>
</head>
<body>
${msg}
<form action="saveFriend" method="post">
	Friend Name: <input type="text" name="friendName"/>
	<br/>
	Friend Location: <input type="text" name="location"/>
	<br/>
	<input type="submit">
</form>
</body>
</html>