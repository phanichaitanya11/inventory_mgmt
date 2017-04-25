$(document).ready(function() {
	$("form[name='searchAgentForm']").validate({
		focusInvalid : true,
		rules : {
			agentId : {
				required : true,
				number : true
			}
		},
		messages : {
			agentId : {
				required : "Please enter Agent ID",
				number : "Agent ID must contain numbers only"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});