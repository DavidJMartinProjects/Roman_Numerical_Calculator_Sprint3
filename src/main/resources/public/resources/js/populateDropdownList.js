function populateDropdown() {
	$.ajax({
		type : 'GET',
		url : "http://localhost:8080/calc/operations",
		contentType : "application/json",
		dataType : "text",
		success : function(operations) {
			for (var i = 0; i < operations.length; i++) {
				$("#operationType").append("<option>" + operations.charAt(i) + "</option>");
			}
		},
		error : function(operations) {
			console.log("inside errorLog");
		}
	});
}

$(document).ready(function() {
	populateDropdown();
});
