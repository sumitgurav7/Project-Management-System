<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view status</title>
<style type="text/css">

.splitleft {
  height: 100%;
  width:18.7%;
  left: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
  color:white;
}


.splitcenter {
  width: 80%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 0px;
  position: absolute;
  top: 250px;
  left: 43%;
  float=right;
  transform: translate(-30%, -50%);
  text-align: left;
  padding-left: 30px;
  background-color: white;
}

.links{
  white-space:pre;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="./images/background4.jpeg">
<div class="splitleft">
<h3>Welcome ${sessionScope.username}</h3></br><h2>CDAC </br>Project Management System</h2>
</div>
<div  class="splitcenter">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a href="newproject" class="links"><font color="white">My Project   </font></a>
				<a href="fileupload" class="links"><font color="white">Files Uploaded   </font></a>
				<a href="viewstat" class="links"><font color="white">View Status  </font></a>
				<a href="stdiscuss" class="links"><font color="white">Discussion   </font></a>
        <a href="logout" class="links"><font color="white">Logout      </font></a>
			</div>
		</div>
		<h3>Status Report</h3>
		<form action="statusreport" method="post">
			<input type="hidden" name="username" value="${sessionScope.username}">
			<input type="submit" value="View">
			<h3>	${statusre}</h3>
		</form>
Title         <input type="text" value="${report.title}" style="width:500px; height:40px;" />


      </br>Abstract   <input type="text" value="${report.abs}" style="width: 500px; height: 80px"> 
      <table>
      <tr>
      	<th>Name of Student </th>
      	<th> PRN </th>
      </tr>
      <c:forEach items="${members}" var="member">
      <tr>
      	<td>${member.fname}</td>
      	<td>${member.pnr}</td>
      </tr>
      </c:forEach>
      </table>
</body>
</html>