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
		<br>
		<br>
<div class="links">Title         <input type="text" value="${report.title}" style="width:500px; height:40px;" /></div>

		<br>
		<br>
      </br><div class="links">Abstract   <input type="text" value="${report.abs}" style="width: 500px; height: 80px"></div> 
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
<!-- <<<<<<< Upstream, based on branch 'master' of https://sumitgurav7@bitbucket.org/prachibhardwaj/online-project-management-system.git -->
   		<br>
		<br>
		<c:forEach items="${statuslist}" var="comm">
		<input type="text" readonly value="${comm.status}"> updated by: ${comm.updatedBy}<br><br>
		</c:forEach>
		<br>
		<form action="addNewStatus" method="post">
		<input type="hidden" name="projectid" value=${report.projectId}>
		<input type="hidden" name="prn" value=${member.pnr}>
		<input type="hidden" name="uname" value="${sessionScope.username}">
		<input type="text" name="newStatus" placeholder="Add new status" id="newStatus" style="width:400px;"/>
		<br><br><input type="submit" value="Add Status"/>
		</form>
		<br>
		<br>
		
		
<%-- =======
      
      <br>
      <br>
      <h4>Status</h4>
      <table>
      	<tr>
      		<th>Time</th>
      		<th>Updated By</th>
      		<th>Status</th>
      	
      	</tr>
      	<c:forEach items="${listret}" var="st">
      	<tr>
      	
      		<td>${st.timestamp}</td>
      		<td>${st.updated_by}</td>
      		<td>${st.description}</td>
      	
      	</tr>
      </c:forEach>
      </table>
      
      
      <form action="addstatus" method="post">
      
	      <input type="text" name="statentry">
	      <input type="hidden" name="username" value="${sessionScope.username}">
	      <input type="submit" value="Submit Status">
      
      
      </form>
>>>>>>> 659ff5c ff --%>
</body>
</html>