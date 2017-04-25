$(document).ready(function() {
	$("form[name='viewAgentForm']").validate({
		focusInvalid : true,
		rules : {
			agentName : {
				required : true,
				minlength : 1,
				maxlength : 50
			},
			address : {
				required : true,
				minlength : 1,
				maxlength : 500
			},
			phoneNum : {
				required : true,
				number : true,
				minlength : 8,
				maxlength : 8
			},
			mobileNum : {
				required : true,
				number : true,
				minlength : 10,
				maxlength : 10
			},
			ratePer1000 : {
				required : true,
				number : true
			},
			rateOfLeaf : {
				required : true,
				number : true
			},
			rateOfTobacco : {
				required : true,
				number : true
			}
		},
		messages : {
			agentName : {
				required : "Please enter Agent Name",
				maxlength : "Name cannot be longer than 50 characters"
			},
			address : {
				required : "Please enter Address",
				maxlength : "Address cannot be longer than 500 characters"
			},
			phoneNum : {
				required : "Please enter Phone Number",
				number : "Phone Number must contain numbers only",
				minlength : "Phone Number cannot be less than 8 numbers",
				maxlength : "Phone Number cannot be more than 8 numbers"
			},
			mobileNum : {
				required : "Please enter Mobile Number",
				number : "Mobile Number must contain numbers only",
				minlength : "Mobile Number cannot be less than 10 numbers",
				maxlength : "Mobile Number cannot be more than 10 numbers"
			},
			ratePer1000 : {
				required : "Please enter Rate Per 1000",
				number : "Rate Per 1000 must contain numbers only"
			},
			rateOfLeaf : {
				required : "Please enter Rate Of Leaf",
				number : "Rate Of Leaf must contain numbers only"
			},
			rateOfTobacco : {
				required : "Please enter Rate Of Tobacco",
				number : "Rate Of Tobacco must contain numbers only"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});