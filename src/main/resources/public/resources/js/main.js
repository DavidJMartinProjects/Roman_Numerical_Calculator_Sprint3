var rootUrl = 'http://localhost:8080/calc'
var populateListURL = 'http://localhost:8080/calc/operations' 

function calculate() {	
	$("#result").text("");
	$("#validationMessage").text("");

	var num1 = $("#numOneTf").val();
	var num2 = $("#numTwoTf").val();
	var operation = $("#operationType").find("option:selected").text();	
	
	if ($("#numOneTf").val() == "" || $("#numTwoTf").val() == "" || $("#numOneTf").val() == null || $("#numTwoTf").val() == null) {
		$("#validationMessage").text("Please Input a Roman Numeral.")
	} else {
		
		$.ajax({
			type : 'GET',
			url : rootUrl+ "?num1="+num1+"&num2="+num2+"&operationType="+encodeURIComponent(operation),
			contentType : "application/json",
			dataType : "text",
			success : function(response) {
				console.log("success");
				$("#result").text("Result : " + response);
				$("#validationMessage").text("");
			},
			error : function(response) {							
				var jsonValue = jQuery.parseJSON( response.responseText );
				$("#validationMessage").text(jsonValue.message);
			}
		});		
	}
}

$(document).on('click', '#calcBtn', function() {
	calculate();
	return false;
});
