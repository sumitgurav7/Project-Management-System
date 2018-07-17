<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

.splitright {
  height: 100%;
  width: 18.7%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
  right: 0;
}

.splitcenter {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
  position: absolute;
  top: 80px;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
  background-color: white;
}

</style>
</head>
<body background="images/background3.jpg">
<div class="splitleft">
	<marquee direction="up" style="height: 100%; text-align: center;"><h3>Welcome to</h3></br><h2>CDAC </br>Project Management System</h2></marquee>
</div>
<div  class="splitcenter">
		<img src="images/cdac-office.jpg" />
		<div class="panel panel-primary">
			<div class="panel-heading">
				<a href="" ><font color="white">HOME</font></a>
				<a href=""><font color="white">ABOUT US</font></a>
				<a href=""><font color="white">CONTACT</font></a>
			</div>
		</div><font color="white">
</div></font>
<div class="splitright"></div>
</body>
</html>