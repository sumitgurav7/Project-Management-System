<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="mystylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
.split {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

.left {
  left: 0;
  background-color: SeaGreen;
}

.right {
  right: 0;
  background-color: Goldenrod;
}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}

.centered img {
  width: 150px;
  border-radius: 50%;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#type").change(function(){
			if($("#type").val() == "faculty") {
				$("#dpt").css('visibility', 'visible');
				$("#dsg").css('visibility', 'visible');
				$("#pnrdiv").css('visibility', 'hidden');
			}
			else if($("#type").val() == "student") {
				$("#dpt").css('visibility', 'visible');
				$("#dsg").css('visibility', 'hidden');
				$("#pnrdiv").css('visibility', 'visible');
			} else{
				$("#pnrdiv").css('visibility', 'hidden');
				$("#dsg").css('visibility', 'hidden');
				$("#dpt").css('visibility', 'hidden');
			}
		});
		
		$("#cpassword").change(function(){
			if($("#password").val() != $("#cpassword").val()){
				alert("password and confirm password does not match");
			}
		});
	})
</script>
</head>
<body>
<div class="split left">
	<div class="centered">
		<h2>Welcome to</h2>
		</br><h1>C-DAC Project Management System</h1>
	</div>
</div>
<div class="split right">
<div class="centered">
<div style="border: solid; align:center; text-align: center;line-height: 26pt">
	<h1>New Registration</h1>
<form action="newregistration">
</br>Name <input type="text" name="fname" placeholder="Full Name"/>
</br>Email id <input type="email" name="email" placeholder="Email id"/>
</br>Password <input type="password" name="password" id="password" placeholder="Password"/>
</br>Confirm Password <input type="password" name="cpassword" id="cpassword" placeholder="Confirm Password"/>
</br>Contact number<input type="phone" name="phn" placeholder="Contact number"/>
</br>You are a 
 <select value="type" id="type" class="type" name="type">
 <option value="empty">   -----</option>
  <option value="admin">Admin</option>
  <option value="faculty">Faculty</option>
  <option value="student">Student</option>
</select>
<div class="pnrdiv" name="pnrdiv" id="pnrdiv" style="visibility: hidden;">PNR <input type="number" name="pnr" placeholder="PNR"/> </div>
<div id="dpt" name="dpt" style="visibility: hidden;">
</br>Department
 <select value="department" name="department">
 <option value="empty">   -----</option>
  <option value="admin">PG-DAC</option>
  <option value="faculty">PG-DITISS</option>
  <option value="student">PG-DMC</option>
  <option value="student">PG-DESD</option>
  <option value="student">PG-DVLSI</option>
</select>
</div>
<div id="dsg" name="dsg" style="visibility: hidden;">
</br>Designation
 <select value="designation" class="designation" name="designation">
 <option value="empty">   -----</option>
  <option value="admin">assistant Faculty</option>
  <option value="faculty">Senior Faculty</option>
  <option value="student">HOD</option>
</select>
</div>

</br><button>Submit</button>
</form>
</div>
</div>
</div>
</body>
</html>