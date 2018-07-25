<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discussions</title>
<style type="text/css">

.links{
  white-space:pre;
}

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
  top: 400px;
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
        <a href="Projects" class="links"><font color="white">Projects Lists   </font></a>
        <!-- <a href="viewStatusFac" class="links"><font color="white">Status   </font></a>
        <a href="" class="links"><font color="white">Comments   </font></a> -->
       <!--  <a href="" class="links"><font color="white">Discussion   </font></a> -->
        <a href="FileUploadFac" class="links"><font color="white">Files   </font></a>
        <a href="logout" class="links"><font color="white">Logout      </font></a>
			</div>
		</div>
		<h2>Discussion</h2>
   		<br>
		<br>
		<c:forEach items="${comments}" var="comm">
		<input type="text" readonly value="${comm.comment}"> updated by: ${comm.updatedBy}<br><br>
		</c:forEach>
		<br>
		<form action="addFacComment" method="post">
		<input type="hidden" name="projectid" value="${proj_id}">
		
		<input type="hidden" name="uname" value="${sessionScope.username}">
		<input type="text" name="newcomment" placeholder="Add new comment" id="newcomment" style="width:400px;"/>
		<br><br><input type="submit" value="Add Comment"/>
		</form>
		<br>
		<br>
</body>
</html>