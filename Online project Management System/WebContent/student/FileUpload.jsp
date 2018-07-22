<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>file upload</title>
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
<body background="./images/background3.jpg">
<div class="splitleft">
<h3>Welcome to</h3></br><h2>CDAC </br>Project Management System</h2>
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
    <h3>Upload Project Related File</h3>
    <br>
    <form id = "uploadfile" method = "post" action = " ">
    <p>Title
    <input type="text" name="textline" size="30">
    </p>
    <p>
    Please specify a file, or a set of files:<br><br>
      <input id = "fileupload" type = "file" />
     </p>
     <div>
      <input type = "submit" value = "submit" id = "submit" />
      </div>
</form>

<h3>Download files here</h3>
<div>
<table style="width:100%" border ="1">
  <caption><b><h3>uploaded files<h3><b></caption>
  <tr>
    <th>Serial No</th>
    <th>File Name</th>
    <th>Download</th>
    
  </tr>
  
</table>
</div>
</div>
</body>
</html>