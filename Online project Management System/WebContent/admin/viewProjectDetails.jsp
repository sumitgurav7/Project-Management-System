<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Project Details</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript">
	$(function(){
	   $(".approveProject").click(function(event){
	       event.preventDefault();
	       var projectid = $(".projectId").val();
	      handleProjectViaAjex(1, projectid);
	   });
	 	   
	   $(".rejectProject").click(function(event){
	       event.preventDefault();
	       var projectid = $(".projectId").val();
	      handleProjectViaAjex(2, projectid);
		});
	 	  
		$(".removeStudent").click(function(event){
			event.preventDefault();
			 var ch_list=Array(); 
			 $("input:checkbox[type=checkbox]:checked").each(function(){
				 ch_list.push($(this).val());
			 });

			var data = {}
			data["listOfStudents"] = ch_list;
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "${pageContext.request.contextPath}/removeStudentsFromProject",
				data : JSON.stringify(data),
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					if(data == true){
						alert("Students Removed Successfully.");	
					} else {
						alert("Something went wrong.");
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
			$("input:checkbox[type=checkbox]:checked").each(function(){
				 $(this).css('visibility', 'hidden');
			 });
/*			$.each(ch_list, function( index, value ) {
				  alert( index + ": " + value );
				  $(".".append(value)).css('visibility', 'hidden');
			});
*/
		});
});
	
	function handleProjectViaAjex(){
    	var data = {}
    	data["projectId"] = arguments[1];
    	data["valToPass"] = arguments[0];
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${pageContext.request.contextPath}/updateProject",
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
  top: 100px;
  overflow-x: hidden;
  padding-top: 0px;
  position: absolute;
  top: 300px;
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


<div style="text-align:center"><h2>${projectObject.title}</h2></div>
<div>Abstract: ${projectObject.abs}</div>
</br></br>
<div>Lead PRN: ${projectObject.lead}</div>
  
  <form>
  	<c:forEach items="${studentList}" var = "j">
  		</br> <input name="messageCheckbox" type="checkbox" id=${j.pnr} value=${j.pnr}><span class=${j.pnr}>${j.fname}</span>
  	</c:forEach>
  	</br><input type="submit" class="removeStudent" value="Remove From Project">
  </form>
  	</br>
  	<div style="text-align:center">
  	<input type="hidden" class="projectId" value="${projectObject.projectId}"/>
    <input type="submit" class="approveProject" value="Approve">
  	<input type="submit" class="rejectProject" value="Reject">
	</div>
</div>
</body>
</html>