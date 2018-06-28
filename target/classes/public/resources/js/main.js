/**
 * 
 */
var rootUrl = 'http://localhost:8080/calc/addition'

$(document).on('click', '#calcBtn', function() {
	calculate();
	return false;
});

function calculate() {
	
	$("#result").text("");
	$("#validationMessage").text("");

	var num1 = $("#numOneTf").val();
	var num2 = $("#numTwoTf").val();
	var operation = $("#operationType").find("option:selected").text();
	var opType;
	
	if(operation == "+") {
		opType = "add";
	} else if(operation == "-") {
		opType = "subtract";
	} else if(operation == "/") {
		opType = "divide";
	} else if(operation == "*") {
		opType = "multiply";
	}
		
	console.log("operation type selected : " + operation);

	if ($("#numOneTf").val() == "" || $("#numTwoTf").val() == "" || $("#numOneTf").val() == null || $("#numTwoTf").val() == null) {
		$("#validationMessage").text("Please Input a Roman Numeral.")
	} else {
		$.ajax({
			type : 'GET',
			url : rootUrl+ "?num1="+num1+"&num2="+num2+"&operationType="+opType,
			contentType : "application/json",
			dataType : "json",
			data : {

			},
			success : function(response) {
				console.log("success");
				$("#result").text("Result : " + num1 + " + " + num2 + " = "	+ response.theResult + "");
				$("#numOneTf").val("");
				$("#numTwoTf").val("");
				$("#validationMessage").text("");
			},
			error : function() {
				console.log("error");
				$("#validationMessage").text("Invalid Roman Numerical Format.")
			}
		});
	}

}
