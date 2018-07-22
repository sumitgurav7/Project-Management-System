<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Member</title>
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
  left: 40%;
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
  <select name="memberby">
    <option>select</option>
    <option value="student">student</option>
    <option value="faculty">faculty</option>
  </select>
    &nbsp; &nbsp; &nbsp; &nbsp;
  <select name="searchby">
    <option>search by</option>
    <option value="email">email-id</option>
    <option value="pnr">PRN</option>
    <option value="dept">Department</option>
  </select>
  &nbsp; &nbsp; &nbsp;
  <input type="text" name="searchvalue"> 
  <br><br>
<button id="selectall">get all</button>
  &nbsp; &nbsp; &nbsp; &nbsp;
<button id="selectone">Search</button>
  </form>


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
  	<td>
  	<form action="delStud" method="post">
  	<input type="hidden" name="pnr" value="${i.pnr}">
  	<input type="submit" value="Delete">
  	</form>
  	</td>
  	<td>
  	<form action="toUpdateStudent" method="post">
  	<input type="hidden" name="pnr" value="${i.pnr}">
  	<input type="hidden" name="fname" value="${i.fname}">
  	<input type="hidden" name="email" value="${i.email}">
  	<input type="hidden" name="deptartment" value="${i.deptartment}">
  	<input type="hidden" name="contact_no" value="${i.contact_no}">
  	<input type="hidden" name="projectId" value="${i.projectId}">
  	<input type="submit" value="Update">
  	</form>
  	
  	</td>
  	
  </tr>
 ${i}
  </c:forEach>
</table>
  
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
  	
  	<th>${k.email_id}</th>
  	<th>${k.name}</th>
  	<th>${k.department}</th>
  	<th>${k.designation}</th>
  	<th>${k.contact_no}</th>
  	<th><form action="delFac" method="post">
  	<input type="hidden" name="id" value="${k.email_id}">
  	<input type="submit" value="Delete">
  	</form></th>
  	<th><form action="toUpdateFacu" method="post">
  	<input type="hidden" name="email_id" value="${k.email_id}">
  	<input type="hidden" name="name" value="${k.name}">
  	<input type="hidden" name="department" value="${k.department}">
  	<input type="hidden" name="designation" value="${k.designation}">
  	<input type="hidden" name="contact_no" value="${k.contact_no}">
  	<input type="submit" value="Update">
  	</form></th>
  
  </tr>
  ${k}
  </c:forEach>  
	
	</table>
<br>
<br>
 <h3>Update Student<h3>
    <div>
    
     PRN         <input type="text" id="pnr" value="${studentObject.pnr}"><br>
    Name       <input type="text" id="name" value="${studentObject.fname}"><br>
    Email-Id   <input type="text" id="email" value="${studentObject.email}"><br>
    Department <input type="text" id="dept" value="${studentObject.deptartment}"><br>
    Contact No <input type="text" id="phn" value="${studentObject.contact_no}"><br>
    Project Id <input type="text" id="projcet" value="${studentObject.projectId}">
    <br><button id="upbtn">Update</button>
  </div>
  <br>
  <h3>Update Faculty<h3>
   <div>
   <form action="" method="post">
    Email-Id   <input type="text" id="email" value="${facultyObject.email_id}"><br>
    Name        <input type="text" id="name" value="${facultyObject.name}"><br>
    Department  <input type="text" id="dept" value="${facultyObject.department}"><br>
    Designation <input type="text" id="design" value="${facultyObject.designation}"><br>
    Contact No <input type="text" id="phn" value="${facultyObject.contact_no}"><br>
    <br><button id="upbtn">Update</button>
    </form>
  </div>
</div>
</body>
</html>