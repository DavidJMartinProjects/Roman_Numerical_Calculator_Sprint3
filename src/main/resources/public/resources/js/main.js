/**
 * 
 */
var rootUrl = 'http://localhost:8080/calc/addition'
	
	 $(document).on('click', '#calcButton', function(){
		 calculate();
	        return false;
		});

	function calculate(){  
		$("#result").text("");
		$("#validationMessage").text("");
		
		var num1 = $("#numOneTf").val();
		var num2 = $("#numTwoTf").val();
		
		$.ajax({
	          type: 'GET',
	          url: rootUrl,
	          contentType: "application/json",
	          dataType: "json",
	          data: {
	        	  num1 : num1,
	        	  num2 : num2
	          },
	          success: function(response){
	        	  $("#result").text("Result : "+num1+" + "+num2+" = "  + response.theResult + "");
	        	  $("#num1").val("");
	        	  $("#num2").val("");
	          },
	          error: function(){
	          	  $("#validationMessage").text("Invalid Roman Numerical Format.")
	          }       
		});
	}



