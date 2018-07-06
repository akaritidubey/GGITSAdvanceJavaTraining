<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Directions Applications</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Directions Applications</h2>
  <form >
    <div class="form-group">
      <label >Source Location:</label>
      <input  class="form-control" id="source" placeholder="Enter source location" >
    </div>
    <div class="form-group">
      <label >Destination Location:</label>
      <input  class="form-control" id="destination" placeholder="Enter destination location" >
    </div>
    
 
    <button type="button" id ="btn1" class="btn btn-default">Get Directions</button>
    <br><br>
    <label id= "result">Directions will be displayed here:</label>
  </form>
</div>

</body>
<script>
$(document).ready(function(){
	
	//2. Check click event on button
	$("#btn1").click(function(){
		// 3. get source and destination
		var src = $("#source").val();
		var dst = $("#destination").val();
		//4. post to servlet get directions
		$.post("getDirections",{'source':src,'destination':dst},function(response){
			//display directions
			$("#result").html(response);
		});
		
		
	});
});
</script>
</html>
