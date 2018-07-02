var rootUrl = 'http://localhost:8080/calc'
var populateListURL = 'http://localhost:8080/calc/operations' 

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

	if ($("#numOneTf").val() == "" || $("#numTwoTf").val() == "" || $("#numOneTf").val() == null || $("#numTwoTf").val() == null) {
		$("#validationMessage").text("Please Input a Roman Numeral.")
	} else {
		
		$.ajax({
			type : 'GET',
			url : rootUrl+ "?num1="+num1+"&num2="+num2+"&operationType="+opType,
			contentType : "application/json",
			dataType : "json",
			success : function(response) {
				console.log("success");
				$("#result").text("Result : " + num1 + " + " + num2 + " = "	+ response.theResult + "");
				$("#numOneTf").val("");
				$("#numTwoTf").val("");
				$("#validationMessage").text("");
			},
			error : function(response) {
				console.log("error");
				
				jsonValue = jQuery.parseJSON( response.responseText );
				console.log(jsonValue.message);
				console.log(jsonValue);
				
				$("#validationMessage").text(jsonValue.message);
			}
		});		
	}
}

$(document).on('click', '#calcBtn', function() {
	calculate();
	return false;
});
