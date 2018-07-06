<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Calculator Websitee</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Calculator Web Application</h2>
  <form>
    <div class="form-group">
      <label >Integer A:</label>
      <input class="form-control" id="inputA" placeholder="Enter Integer A" >
    </div>
     <div class="form-group">
      <label >Integer B:</label>
      <input class="form-control" id="inputB" placeholder="Enter Integer B" >
    </div>
    
   
    <button type="button" id ="btnAdd" class="btn btn-default">Add</button>
    <button type="button" id ="btnSub" class="btn btn-default">Subtract</button>
    <button type="button" id ="btnMul" class="btn btn-default">Multiply</button>
    <button type="button" id ="btnDiv" class="btn btn-default">Divide</button>
    
    <br><br>
	<label id="lblRes">Result will be displayed here</label>

  </form>
</div>


</body>
<script>
//1.) Check if the webpage has loaded
//Execute only if webpage is ready
$(document).ready(function(){
	//2.) cllick event handling on buttons
	
	$("#btnAdd").click(function(){
		//3.)read intA and intB from input boxes
		
		var intA = $("#inputA").val();
		var intB = $("#inputB").val();
		
		//4.) send the parameters to servlet -> operation 
		//$.post(url,parameters to be transmitted,callback[response]);// post is an action and  $ is object
		$.post("operation",{'intA':intA,'intB':intB,'opn':'opAdd'},function(response){
			//5.) Display Response on label control
			$("#lblRes").html(response);
		} );
	});
	
	//SUBTRACT FUNCTION Starts here
	$("#btnSub").click(function(){
			//3.)read intA and intB from input boxes
			
			var intA = $("#inputA").val();
			var intB = $("#inputB").val();
			
			//4.) send the parameters to servlet -> operation 
			//$.post(url,parameters to be transmitted,callback[response]);// post is an action and  $ is object
			$.post("operation",{'intA':intA,'intB':intB,'opn':'opSub'},function(response){
				//5.) Display Response on label control
				$("#lblRes").html(response);
			} );
		});
	//SUBTRACT FUNCTION ENDS here
	//MULTIPLY FUNCTION Starts here
	$("#btnMul").click(function(){
			//3.)read intA and intB from input boxes
			
			var intA = $("#inputA").val();
			var intB = $("#inputB").val();
			
			//4.) send the parameters to servlet -> operation 
			//$.post(url,parameters to be transmitted,callback[response]);// post is an action and  $ is object
			$.post("operation",{'intA':intA,'intB':intB,'opn':'opMultiply'},function(response){
				//5.) Display Response on label control
				$("#lblRes").html(response);
			} );
		});
	//MULTIPLY FUNCTION ENDS here
	//DIVIDE FUNCTION Starts here
	$("#btnDiv").click(function(){
			//3.)read intA and intB from input boxes
			
			var intA = $("#inputA").val();
			var intB = $("#inputB").val();
			
			//4.) send the parameters to servlet -> operation 
			//$.post(url,parameters to be transmitted,callback[response]);// post is an action and  $ is object
			$.post("operation",{'intA':intA,'intB':intB,'opn':'opDivide'},function(response){
				//5.) Display Response on label control
				$("#lblRes").html(response);
			} );
		});
	//DIVIDE FUNCTION ENDS here
	
	
	
});
</script>
</html>
