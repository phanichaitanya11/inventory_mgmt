$(document).ready(function() {
	$("form[name='newOutgoingTranForm']").validate({
		focusInvalid : true,
		rules : {
			tranDate : {
				required : true,
				date : true
			},
			leafIssuedVol : {
				required : true,
				number : true
			},
			mixTobIssuedVol : {
				required : true,
				number : true
			},
			advCashPaid : {
				number : true
			}
		},
		messages : {
			tranDate : {
				required : "Please enter Transaction Date",
				Date : "Invalid date!"
			},
			leafIssuedVol : {
				required : "Please enter Leaf Volume Issued",
				number : "Leaf Volume Issued must contain numbers only"
			},
			mixTobIssuedVol : {
				required : "Please enter Mixed Tobacco Volume Issued",
				number : "Mixed Tobacco Volume Issued must contain numbers only"
			},
			advCashPaid : {
				number : "Advanced Amoun must contain numbers only"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});