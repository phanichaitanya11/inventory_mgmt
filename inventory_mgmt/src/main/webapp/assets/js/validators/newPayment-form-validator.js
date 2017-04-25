$(document).ready(function() {
	$("form[name='newPaymentForm']").validate({
		focusInvalid : true,
		rules : {
			paymentDate : {
				required : true,
				date : true,
			},
			amount : {
				required : true,
				number : true
			}
		},
		messages : {
			paymentDate : {
				required : "Please enter Payment Date",
				date : "Invalid date!"
			},
			amount : {
				required : "Please enter Amount",
				number : "Amount must contain numbers only"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});