<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello Student</h1>
	<a href="hmpg">Home</a><hr>
	<form action="student_logins" method="post">
	${entryVali}<hr>
		Username: <input type="text" name="username">
		Password: <input type="text" name="password">
		<input type="submit"><br>
		<a href="regi">New User? Sign Up here</a>
	
	</form>

</body>
</html>