<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<table>
		<tr>
			<td><a href='<c:url value="../User/ChangePassword"/>'>Change Password</a></td>
			<td><a href='<c:url value="../User/UpdateInfo"/>'>Update Info</a></td>
			<td><a href='<c:url value="../User/LogOut"/>'>Log Out</a></td>
		</tr>
	</table>
	<h1>Welcome to miniblog !!!</h1>
</body>
</html>