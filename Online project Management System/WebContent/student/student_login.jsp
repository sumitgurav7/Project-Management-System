<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
</head>
<body background="./images/background3.jpg">
<jsp:include page="./header.jsp"/>
	<div style="text-align:center;"><h1>Welcome Student</h1>
	<form action="student_logins" method="post">
	${entryVali}<hr>
		Username: <input type="text" name="username">
	</br></br>Password: <input type="password" name="password">
	</br></br><input type="submit" value="Login"><br>
	</br></br></br><a href="regi">New User? Sign Up here</a>
	
	</form>
	</div>
</body>
</html>