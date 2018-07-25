<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Member</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#memberby").change(function(){
			if($("#memberby").val() == "faculty") {
				var newOptions = {"All" : "all",
							"Email": "email",
					  		"Department": "department"};

				var $el = $("#searchby");
				$el.empty(); // remove old options
				$.each(newOptions, function(key,value) {
				  $el.append($("<option></option>")
				     .attr("value", value).text(key));
				});
			}
			if($("#memberby").val() == "student") {
				var newOptions = {"All" : "all",
								"Email": "email",
						  		"Department": "department",
						  		"PRN": "prn"};
				var $el = $("#searchby");
				$el.empty(); // remove old options
				$.each(newOptions, function(key,value) {
				  $el.append($("<option></option>")
				     .attr("value", value).text(key));
				});
			}
		});
		
		$(".deleteStudent").click(function(event){
			event.preventDefault();
			var prn = $(this).parent().siblings("td:eq(0)").text();
			processDelete(1, prn);
		});
		
		$(".deleteFaculty").click(function(event){
			event.preventDefault();
			var emailid = $(this).parent().siblings("td:eq(0)").text();
			processDelete(2, emailid);
		});
		
		$(".updateStudent1").click(function(event){
			event.preventDefault();
			$("#spnr").val($(this).parent().siblings("td:eq(0)").text());
			$("#sname").val($(this).parent().siblings("td:eq(1)").text());
			$("#semail").val($(this).parent().siblings("td:eq(2)").text());
			$("#sdept").val($(this).parent().siblings("td:eq(3)").text());
			$("#sphn").val($(this).parent().siblings("td:eq(4)").text());
			$("#spid").val($(this).parent().siblings("td:eq(5)").text());
		});
		
		$(".updateFaculty1").click(function(event){
			event.preventDefault();
			$("#femail").val($(this).parent().siblings("td:eq(0)").text());
			$("#fname").val($(this).parent().siblings("td:eq(1)").text());
			$("#fdept").val($(this).parent().siblings("td:eq(2)").text());
			$("#fdesign").val($(this).parent().siblings("td:eq(3)").text());
			$("#fphn").val($(this).parent().siblings("td:eq(4)").text());
		});
		
		$("#upbtnstu").click(function(event){
			event.preventDefault();
			var data = {}
			data["prn"] = $("#spnr").val();
			data["name"] = $("#sname").val();
			data["dept"] = $("#sdept").val();
			data["phn"] = $("#sphn").val();
			data["pid"] = $("#spid").val();
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "${pageContext.request.contextPath}/updateStudent",
				data : JSON.stringify(data),
				dataType : 'json',
				async : false,
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					if(data == true){
						alert("Student updated successfully");	
					} else {
						alert("Student coult not be updated successfully");
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
		
		$("#upbtnfac").click(function(event){
			event.preventDefault();
			var data = {}
			data["email"] = $("#femail").val();
			data["name"] = $("#fname").val();
			data["dept"] = $("#fdept").val();
			data["phn"] = $("#fphn").val();
			data["design"] = $("#fdesign").val();
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "${pageContext.request.contextPath}/updateFaculty",
				data : JSON.stringify(data),
				dataType : 'json',
				async : false,
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					if(data == true){
						alert("Faculty updated successfully");	
					} else {
						alert("Faculty coult not be updated successfully");
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
	
	function processDelete(){
		var data = {}
		data["id"] = arguments[1];
		data["membertype"] = arguments[0];
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${pageContext.request.contextPath}/deleteProcess",
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
	}
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
  top: 0;
  overflow-x: hidden;
  padding-top: 0px;
  position: absolute;
  top: 550px;
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
        <a href="pendingapp" class="links"><font color="white">Pending Approval   </font></a>
        <a href="viewmember" class="links"><font color="white">View Member  </font></a>
        <a href="assignFaculty" class="links"><font color="white">Assign Faculty  </font></a>
        <a href="logout" class="links"><font color="white">Logout      </font></a>
      </div>
    </div>
    

    <h3>Search Member</h3>
    <br>
  <form id="projectform" action="viewdata" method="post">
  <select name="memberby" id="memberby">
    <option value="student">student</option>
    <option value="faculty">faculty</option>
  </select>
    &nbsp; &nbsp; &nbsp; &nbsp;
  <select name="searchby" id="searchby">
    <option value="all">All</option>
    <option value="email">email-id</option>
    <option id="prn" value="pnr">PRN</option>
    <option value="dept">Department</option>
  </select>
  &nbsp; &nbsp; &nbsp;
  <input type="text" name="searchvalue"> 
  <br><br>
  <button id="selectall">get all</button>
  &nbsp; &nbsp; &nbsp; &nbsp;
<button id="selectone">Search</button>
  </form>


<div id="studentDetailTableDiv">
   <table style="width:100%" border ="1">   
  <caption><b><h3>Student Details<h3><b></caption>
  <tr>
    <th>PRN</th>
    <th>Name</th>
    <th>Email Id</th>
    <th>Department</th>
    <th>Contact No</th>
    <th>Project Id</th>
    <th>Delete</th>
    <th>Update</th>
  </tr>
  <c:forEach items="${viewAllKey}" var = "i">
  <tr>
  	
  	<td>${i.pnr}</td>
  	<td>${i.fname}</td>
  	<td>${i.email}</td>
  	<td>${i.deptartment}</td>
  	<td>${i.contact_no}</td>
  	<td>${i.projectId}</td>
  	<td> <input type="submit" class="deleteStudent" value="Delete"></td>
  	<td><input type="submit" class="updateStudent1" value="Update"></td>
  	
  </tr>
  </c:forEach>
</table>
  </div>
  <div id="facultytabdiv">
   <table style="width:100%" border ="1">
  <caption><b><h3>Faculty Details<h3><b></caption>
  <tr>
    <th>Email Id</th>
    <th>Name  </th>
    <th>Department</th>
    <th>Designation</th>
    <th>Contact No</th>
    <th>Delete</th>
    <th>Update</th>
  </tr> 
  <c:forEach items="${viewAllKeyFaculty}" var = "k">
  <tr>
  	
  	<td>${k.email_id}</td>
  	<td>${k.name}</td>
  	<td>${k.department}</td>
  	<td>${k.designation}</td>
  	<td>${k.contact_no}</td>
  	<td><input type="submit" class="deleteFaculty" value="Delete"></td>
  	<td><input type="submit" class="updateFaculty1" value="Update"></td>
  
  </tr>
  </c:forEach>  
</table>
</div>
<br>
<br>
    <div id="updateStudentDiv" style="white-space:pre;float:left;width:30%;text-align:right;">
    </br>
     <h3>Update Student</h3>
     PRN         <input type="text" readonly id="spnr" value=""><br>
    Name       <input type="text" id="sname" value=""><br>
    Email-Id   <input type="text" readonly id="semail" value=""><br>
    Department <input type="text" id="sdept" value=""><br>
    Contact No <input type="text" id="sphn" value=""><br>
    Project Id <input type="text" id="spid" value="">
    <br><button id="upbtnstu">Update</button>
  </div>
  <br>
   <div id="updateFacultyDiv" style="white-space:pre;float:right; width:50%;text-align:left;">
  	<h3>  Update Faculty</h3>
   <form action="" method="post">
    Email-Id   <input type="text" readonly id="femail" value="${facultyObject.email_id}"><br>
    Name        <input type="text" id="fname" value="${facultyObject.name}"><br>
    Department  <input type="text" id="fdept" value="${facultyObject.department}"><br>
    Designation <input type="text" id="fdesign" value="${facultyObject.designation}"><br>
    Contact No <input type="text" readonly id="fphn" value="${facultyObject.contact_no}"><br>
    <br><button id="upbtnfac">Update</button>
    </form>
  </div>
</div>
</body>
</html>