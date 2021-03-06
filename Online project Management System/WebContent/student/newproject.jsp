<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Project Entry</title>
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
  top: 350px;
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
  <script type="text/javascript">
    $(function(){
    	window.teampnrs = []
        $("#leadsearchbutton").click(function(event){
            event.preventDefault();
            searchViaAjax();
        });
        
        $("#membersearchbutton").click(function(event){
        	event.preventDefault();
        	searchMemberViaAjax();
        });
        
        $("#selectmember").click(function(event){
        	event.preventDefault();
        	if($("#singlemember").val() != ""){
                var found = 0;
                for(var i=0; i < teampnrs.length; i++){
               	 if(teampnrs[i] == $("#member").val()){
               		 found = 1;
               	 }
                }
                if(found == 0){
                	teampnrs.push($("#member").val());
                	$("#allmember").append("<li>" + $("#singlemember").val() + "</li>");
                }
        	}
        	
        });
        
        $("#formsubmit").click(function(event){
        	var data = {}
        	teampnrs.push($("#teamlead").val());
        	data["title"] = $("#title").val();
        	data["abs"] = $("#abstract").val();
        	data["lead"] = $("#teamlead").val();
        	data["members"] = teampnrs;
        	var jsonString = JSON.stringify(teampnrs);
        	$.ajax({
    			type : "POST",
    			contentType : "application/json",
    			url : "${pageContext.request.contextPath}/createNewProject",
    			data : JSON.stringify(data),
    			dataType : 'json',
    			ajax : false,
    			timeout : 100000,
    			success : function(data) {
    				console.log("SUCCESS: ", data);
    				if(data == true){
    					alert("Project created successfully");	
    				} else {
    					alert("Something went wrong. Please ensure that no member of the team is already associated with any other project (approve/pending approval)");
    				}
    			},
    			error : function(e) {
    				console.log("ERROR: ", e);
    				//alert(e);
    			},
    			done : function(e) {
    				console.log("DONE");
    			}
    		});
        });
    })

    function searchViaAjax() {
      var data = {}
      var pnr = $("#teamlead").val();
      $.ajax({
         type : "GET",
         url : "${pageContext.request.contextPath}/getStudentByPnr",
         data : {
         "pnr" : pnr
        },
         success : function(data) {
         console.log("SUCCESS: ", data);
         $("#leadfinalname").val(data);         
        },
        error : function(e) {
          console.log("ERROR: ", e);
          alert("No student found with PNR " + pnr);
          $("#teamlead").val("");
          //display(e);
        },
        done : function(e) {
          console.log("DONE");
        }
      });
    }
      
      function searchMemberViaAjax() {
        var data = {}
        var pnr = $("#member").val();
        $.ajax({
           type : "GET",
           url : "${pageContext.request.contextPath}/getStudentByPnr",
           data : {
           "pnr" : pnr
          },
           success : function(data) {
           
           if(data.length > 0) {
           		$("#singlemember").val(data);
           		console.log("SUCCESS: ", data);
           } else {
        	   alert("No student found with PRN " + pnr);
           }
          },
          error : function(e) {
            console.log("ERROR: ", e);
            alert("No student found with PRN " + pnr);
            $("#member").val("");
          },
          done : function(e) {
            console.log("DONE");
          }
        });
      }
  </script>

</head>
<body background="./images/background4.jpeg">
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
    <h3>Create New Project</h3>
    <br>
    <div class="links">
	<form id="projectform" action="">
      <br>Title         <input type="text" id="title" placeholder="Project Title" style="width:500px; height:40px;" />


      <br>Abstract   <input type="text" id="abstract" placeholder="Abstract" style="width: 500px; height: 80px"> 

        <br>Team Leader   <input type="text" name="teamlead" id="teamlead" placeholder="PRN">  <button id="leadsearchbutton">search</button>  <input type="text" id="leadfinalname" readonly >
        <br>Team Members  <input type="text" id="member" placeholder="PRN">  <button id="membersearchbutton">search</button>  <input id="singlemember" type="text" readonly >  <button id="selectmember">+ Add</button>  <span id="allmember" style="height: 70px;"></span>
      <br><br><button id="formsubmit">Create Project</button>
      </form>
    </div> 
</div>
</body>
</html>