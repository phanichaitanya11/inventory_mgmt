<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="include.jsp"%>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Inventory Management</title>
<link rel="stylesheet" href="assets/css/datepicker.min.css" />
<link rel="stylesheet" href="assets/css/datepicker3.min.css" />
</head>
<body>
	<div id="wrapper">
		<%@ include file="frameTop.html"%>
		<jsp:include page="frameLeft.jsp" />
	</div>
	<script src="assets/js/validators/outgoingDailyTran-form-validator.js"></script>
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- Form Elements -->
					<div class="panel panel-primary">
						<div class="panel-heading">
                            Search Agent
                        </div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<form:form method="POST" name="searchAgentForm" id="searchAgentForm" action="searchAgentForTran" modelAttribute="newTranForm">
										<div class="form-group">
	                                        <div class="input-group">
												<div class="input-group">
		                                            <span class="input-group-addon">Agent ID</span>
		                                            <form:input path="agentId" name="agentId" class="form-control" placeholder="Agent ID" />
		                                        </div>
												<span class="input-group-btn">
													<button class="btn btn-default" type="submit">Search</button>
												</span>
												<form:hidden path="tranType" name="tranType" value="O"/>
											</div>
										</div>
										<c:if test="${result == 'success'}">
											<div class="form-group has-success col-md-10">
												<label class="control-label" for="inputSuccess">${msg}</label><br/>
												<label class="control-label" for="inputSuccess">Transaction Id : ${transactionId}</label>
											</div>
										</c:if>
										<c:if test="${result == 'error'}">
											<div class="form-group has-error">
												<label class="control-label" for="inputError"><h3>${msg}</h3></label>
											</div>
										</c:if>
									</form:form>
								</div>
							</div>
						</div>
					</div>
					
					<!-- Agent details div start -->
					<c:if test="${agentExist}">
						<div class="panel panel-primary">
							<div class="panel-heading">
	                            Agent Details
	                        </div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-10">
										<form:form class="form-horizontal" modelAttribute="agentInfo">
											<div class="form-group">
	                                            <label for="agentId" class="col-sm-3 control-label">Agent ID</label>
	                                            <div class="col-sm-5">
												  <form:input id="agentId" path="agentId" name="agentId" class="form-control" placeholder="Agent ID" disabled="true"/>
												</div>
	                                           	<form:hidden path="agentId" name="agentId"/>
	                                        </div>
											<div class="form-group">
												<label for="agentName" class="col-sm-3 control-label">Agent Name</label>
												<div class="col-sm-5">
												  <form:input id="agentName" path="agentName" name="agentName" class="form-control" placeholder="Agent Name" disabled="true"/>
												</div>
												<label class="col-sm-4 checkbox-inline">
	                                                <form:checkbox path="tempFlag" name="tempFlag" disabled="true"/>Is Temporary?
	                                            </label>
											</div>
											<div class="form-group">
												<label for="ratePer1000" class="col-sm-3 control-label">Rate per 1000</label>
		                                    	<div class="col-sm-5">
													<form:input path="ratePer1000" name="ratePer1000" id="ratePer1000" class="form-control" placeholder="Rate per 1000" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<label for="rateOfLeaf" class="col-sm-3 control-label">Rate of Leaf</label>
		                                    	<div class="col-sm-5">
													<form:input path="rateOfLeaf" name="rateOfLeaf" id="rateOfLeaf" class="form-control" placeholder="Rate of Leaf" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<label for="rateOfTobacco" class="col-sm-3 control-label">Rate of Tobacco</label>
		                                    	<div class="col-sm-5">
													<form:input path="rateOfTobacco" id="rateOfTobacco" name="rateOfTobacco" class="form-control" placeholder="Rate of Tobacco" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">&nbsp;</div>
		                                    	<div class="col-sm-5">
													<button type="button" id="newTransactionBtn" name="newTransactionBtn" class="btn btn-default">New Outgoing Transaction</button>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
						<!-- Agent details div end -->
						
						<!-- Payment div start -->
						<div id="newTranDiv" class="panel panel-primary" style="display: none;">
							<div class="panel-heading">
	                            New Outgoing Transaction
	                        </div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-10">
										<form:form class="form-horizontal" name="newOutgoingTranForm" id="newOutgoingTranForm" method="POST" action="newOutgoingTran" modelAttribute="newTranForm">
											<div class="form-group">
	                                            <label for="agentId" class="col-sm-3 control-label">Agent ID</label>
	                                            <div class="col-sm-5">
												  <form:input id="agentId" path="agentId" name="agentId" class="form-control" placeholder="Agent ID" disabled="true"/>
												</div>
	                                           	<form:hidden path="agentId" name="agentId"/>
	                                           	<form:hidden path="tranType" name="tranType" value="O"/>
	                                        </div>
											<div class="form-group">
	                                            <label for="Outstanding Balance" class="col-sm-3 control-label">Outstanding Balance</label>
	                                            <div class="col-sm-5">
	                                           		<b><c:out value="${agentInfo.outstandingBal}"></c:out></b>
												</div>
	                                        </div>
											<div class="form-group">
										        <label for="date" class="col-sm-3 control-label">Date</label>
										        <div class="col-sm-5 date">
										            <div class="input-group input-append date" id="datePicker">
										            	<form:input id="date" path="tranDate" name="date" class="form-control" placeholder="MM/DD/YYYY"/>
										                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
										            </div>
										        </div>
										    </div>
										    <div class="form-group">
												<label for="leafIssuedVol" class="col-sm-3 control-label">Leaf Volumne Issued</label>
		                                    	<div class="col-sm-5">
													<form:input path="leafIssuedVol" name="leafIssuedVol" id="leafIssuedVol" class="form-control" placeholder="Leaf Issued Volume"/>
												</div>
											</div>
											<div class="form-group">
												<label for="mixTobIssuedVol" class="col-sm-3 control-label">Tobacco Volume Issued</label>
		                                    	<div class="col-sm-5">
													<form:input path="mixTobIssuedVol" name="mixTobIssuedVol" id="mixTobIssuedVol" class="form-control" placeholder="Tobacco Issued Volume"/>
												</div>
											</div>
											<div class="form-group">
												<label for="reject2Vol" class="col-sm-3 control-label">Advance Amount Paid</label>
		                                    	<div class="col-sm-5">
													<form:input path="advCashPaid" name="advCashPaid" id="advCashPaid" class="form-control" placeholder="Advance Cash Paid"/>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">&nbsp;</div>
												<button type="submit" class="btn btn-default">Submit</button>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
						<!-- Payment div end -->
						
					</c:if>
				</div>
			</div>
			
		</div>
	</div>
</body>

<script src="assets/js/bootstrap/bootstrap-datepicker.js"></script>
<script>
$(document).ready(function() {
    $('#datePicker').datepicker({
		autoclose: true,
        format: 'mm/dd/yyyy'
    })
    
    $('#newTransactionBtn').click(function() {
   		$('#newTranDiv').toggle();
   	});
});
</script>
</html>