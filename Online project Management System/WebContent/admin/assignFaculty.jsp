<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Supervisor</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script>
	$(function(){
		$(".assignguide").click(function(event){
			event.preventDefault();
			var data = {}
			data["projectid"] = $(this).parent().siblings("td:eq(0)").text();
			var t = "#".concat(data["projectid"]);
			t = t.concat(" :selected");
			data["facultyemail"] = $(t).val();
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "${pageContext.request.contextPath}/assignFacultyToProject",
				data : JSON.stringify(data),
				dataType : 'json',
				async : false,
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					if(data == true){
						alert("Action completed successfully");	
					} else {
						alert("Action did not complete successfully");
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
					alert(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		});
	});
	
</script>
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
  top: 100px;
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

</head>
<body background="./images/background4.jpeg">
<div class="splitleft">
<h3>Welcome to</h3></br><h2>CDAC </br>Project Management System</h2>
</div>
<div  class="splitcenter">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <a href="pendingapp" class="links"><font color="white">Pending Approval   </font></a>
        <a href="viewmember" class="links"><font color="white">View Member  </font></a>
        <a href="assignFaculty" class="links"><font color="white">Assign Supervisor  </font></a>
        <a href="logout" class="links"><font color="white">Logout      </font></a>
      </div>
    </div>

<table style="width:100%" border ="1">
  <caption><b><h3>Pending Project<h3><b></caption>
  <tr>
    <th>Project Id</th>
    <th>Title  </th>
    <th>Lead PRN</th>
    <th>Supervisor</th>
    <th>Assign Supervisor</th>
  </tr>
  <c:forEach items="${pendingProjectList}" var = "j">
  <tr>
  	
  	<td>${j.projectId}</td>
  	<td>${j.title}</td>
  	<td>${j.lead}</td>
  	<td>
	 <select class="faculty" id=${j.projectId} name="faculty">
	 	<c:forEach items="${facultylist}" var = "i">
  			<option value=${i.email_id}>${i.name}</option>
  		</c:forEach>
	</select>
  	</td>
  	<td>
  	<input type="submit" class="assignguide" value="Assign Guide">
  	</td>
  </tr>
  </c:forEach>  
</table>

</div>
</body>
</html>