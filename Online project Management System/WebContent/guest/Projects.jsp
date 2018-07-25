<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project list</title>
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
  top: 200px;
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
<h3>Welcome to</h3></br><h2>CDAC </br>Project Management System</h2>
</div>
<div  class="splitcenter">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <a href="guestProjects" class="links"><font color="white">Projects Lists   </font></a>
        <!-- <a href="viewStatusFac" class="links"><font color="white">Status   </font></a>
        <a href="" class="links"><font color="white">Comments   </font></a>
        <a href="" class="links"><font color="white">Notification   </font></a> -->
        <!-- <a href="FileUploadFac" class="links"><font color="white">Files   </font></a> -->
        <a href="logout" class="links"><font color="white">Logout      </font></a>
      </div>
    </div>
    
    
    <div id="projectDetailTableDiv">
   <table style="width:100%" border ="1">
  <caption><b><h3>Project List<h3><b></caption>
  <tr>
  	<th>Id</th>
    <th>Title  </th>
    <th>View Details</th>
  </tr>
  <c:forEach items="${ProjectList}" var = "j">
  <tr>
  
  	<td>${j.projectId}</td>
  	<td>${j.title}</td>
  	<td>
  	<form action="viewGuestProjectDetail" method="post" >
  	<input style="width:100%" type="hidden" name="project_id" id="project_id" value="${j.projectId}" />
  	<input type="submit" value="View Details">
  	</form>
  	</td>
  </tr>
  </c:forEach>  
</table>
  </div>
</div>




</body>
</html>