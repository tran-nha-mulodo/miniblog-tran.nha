<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Post</title>
</head>
<body>
	<h1>MiniBlog</h1>
	<h3>Edit Posts </h3>
	<table>
		<tr>
			<td>Title</td>
			<td>${Post.title}</td>
		</tr>
		<tr>
			<td>Content</td>
			<td>${Post.content}</td>
		</tr>
	</table>
</body>
</html>