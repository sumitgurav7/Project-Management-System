<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body background="/images/background3.jpg">
<div class="splitleft">
<h3>Welcome to</h3></br><h2>CDAC </br>Project Management System</h2>
</div>
<div  class="splitcenter">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <a href="PendingApproval.jsp" class="links"><font color="white">Pending Approval   </font></a>
        <a href="ViewMember.jsp" class="links"><font color="white">View Member  </font></a>
        <a href="../logout.jsp" class="links"><font color="white">Logout      </font></a>
      </div>
    </div>
    

    <h3>Search Member</h3>
    <br>
  <form id="projectform" action="">
  <select name="member">
    <option>select</option>
    <option value="student">student</option>
    <option value="faculty">faculty</option>
  </select>
    &nbsp; &nbsp; &nbsp; &nbsp;
  <select name="member">
    <option>search by</option>
    <option value="email">email-id</option>
    <option value="pnr">PNR</option>
    <option value="dept">Department</option>
  </select>
  &nbsp; &nbsp; &nbsp; &nbsp;
  <input type="text" id="member" placeholder="Value">
  <br><br>
<button id="selectmember">get all</button>
  &nbsp; &nbsp; &nbsp; &nbsp;
<button id="member">Search</button>
  </form>

   <table style="width:100%" border ="1">
  <caption><b><h3>Student Details<h3><b></caption>
  <tr>
    <th>PNR</th>
    <th>Name</th>
    <th>Email Id</th>
    <th>Department</th>
    <th>Contact No</th>
    <th>Project Id</th>
    <th>Option</th>
  </tr>
  
</table>
  
   <table style="width:100%" border ="1">
  <caption><b><h3>Faculty Details<h3><b></caption>
  <tr>
    <th>Email Id</th>
    <th>Name  </th>
    <th>Department</th>
    <th>Designation</th>
    <th>Contact No</th>
    <th>Option</th>
  </tr>   
  
</table>
<br>
<br>
  <h3>Update Student<h3>
    <div>
     PNR         <input type="text" id="pnr"><br>
    Name       <input type="text" id="name"><br>
    Email-Id   <input type="text" id="email"><br>
    Department <input type="text" id="dept"><br>
    Contact No <input type="text" id="phn"><br>
    Project Id <input type="text" id="projcet">
    <br><button id="upbtn">Update</button>
  </div>
  <br>
  <h3>Update Faculty<h3>
   <div>
    Email-Id   <input type="text" id="email"><br>
    Name        <input type="text" id="name"><br>
    Department  <input type="text" id="dept"><br>
    Designation <input type="text" id="projcet"><br>
    Contact No <input type="text" id="phn"><br>
    <br><button id="upbtn">Update</button>
  </div>
</div>
</body>
</html>