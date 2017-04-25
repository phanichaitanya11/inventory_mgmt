$(document).ready(function() {
	$("form[name='newIncomingTranForm']").validate({
		focusInvalid : true,
		rules : {
			tranDate : {
				required : true,
				date : true
			},
			totalProdVolume : {
				required : true,
				number : true
			},
			approvedVol : {
				required : true,
				number : true
			},
			reject1Vol : {
				required : true,
				number : true
			},
			reject2Vol : {
				required : true,
				number : true
			}
		},
		messages : {
			tranDate : {
				required : "Please enter Transaction Date",
				Date : "Invalid date!"
			},
			totalProdVolume : {
				required : "Please enter Total Products Volume",
				number : "Total Products Volume must contain numbers only"
			},
			approvedVol : {
				required : "Please enter Approved Volume",
				number : "Approved Volume must contain numbers only"
			},
			reject1Vol : {
				required : "Please enter Reject 1 Volume",
				number : "Reject 1 Volume must contain numbers only"
			},
			reject2Vol : {
				required : "Please enter Reject 2 Volume",
				number : "Reject 2 Volume must contain numbers only"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});