var rootUrl = 'http://localhost:8080/calc'
var populateListURL = 'http://localhost:8080/calc/operations'

function calculate() {

	$("#response").html("");
    $(".alert").alert('close')
	
    var num1 = $("#numOneTf").val();
    var num2 = $("#numTwoTf").val();
    var operation = $("#operationType").find("option:selected").text();

    if ($("#numOneTf").val() == "" || $("#numTwoTf").val() == "") {
        $("#response").animate({}, 300);
        $('<div class="alert alert-danger" style="width:800px;" ><b>error : </b>' + "please input a roman numeral." + '</div>').hide().appendTo('#response').fadeIn(1000);
    } else {
        $.ajax({
            type: 'GET',
            url: rootUrl + "?num1=" + num1 + "&num2=" + num2 + "&operationType=" + encodeURIComponent(operation),
            contentType: "application/json",
            dataType: "text",
            success: function(response) {
                $(".alert").alert('close')
                $("#response").animate({}, 300);
                $('<div class="alert alert-success" style="width:800px;" ><b>Result : </b>' + response + '</div>').hide().appendTo('#response').fadeIn(1000);
            },
            error: function(response) {
                $("#response").animate({}, 300);
                var jsonValue = jQuery.parseJSON(response.responseText);
                $('<div class="alert alert-danger" style="width:800px;" >' + jsonValue.message + '</div>').hide().appendTo('#response').fadeIn(1000);
            }
        });
    }
}

$(document).on('click', '#calcBtn', function() {
    calculate();
    return false;
});

$(document).ready(function() {});