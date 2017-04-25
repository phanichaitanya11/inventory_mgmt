<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="include.jsp"%>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Inventory Management</title>

</head>
<body>
	<div id="wrapper">
		<%@ include file="frameTop.html"%>
		<jsp:include page="frameLeft.jsp" />
	</div>
	<script src="assets/js/validators/addAgent-form-validator.js"></script>
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- Form Elements -->
					<div class="panel panel-primary">
						<div class="panel-heading">
                            Add Agent Details
                        </div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<c:choose>
										<c:when test = "${result == null }">
											<form:form class="form-horizontal" name="addAgentForm" id="addAgentForm" method="POST" action="addAgent" modelAttribute="addAgentForm">
												<div class="form-group">
													<label for="agentName" class="col-sm-2 control-label">Agent Name</label>
													<div class="col-sm-4">
													  <form:input id="agentName" path="agentName" name="agentName" class="form-control" placeholder="Agent Name" />
													</div>
												</div>
												<div class="form-group">
													<label for="tempFlag" class="col-sm-2 control-label">Is Temporary?</label>
													<div class="col-sm-4 checkbox-inline">
		                                                <form:checkbox path="tempFlag" name="tempFlag"/>
		                                            </div>
												</div>
												<div class="form-group">
													<label for="address" class="col-sm-2 control-label">Address</label>
													<div class="col-sm-4">
														<form:textarea id="address" path="address" name="address" class="form-control" placeholder="Address" rows="3"></form:textarea>
													</div>
												</div>
												<div class="form-group">
													<label for="phoneNum" class="col-sm-2 control-label">Phone Number</label>
			                                    	<div class="col-sm-4">
														<form:input path="phoneNum" id="phoneNum" name="phoneNum" class="form-control" placeholder="Phone Number" />
													</div>
												</div>
												<div class="form-group">
													<label for="mobileNum" class="col-sm-2 control-label">Mobile Number</label>
			                                    	<div class="col-sm-4">
														<form:input path="mobileNum" id="mobileNum" name="mobileNum" class="form-control" placeholder="Mobile Number" />
													</div>
												</div>
												<div class="form-group">
													<label for="ratePer1000" class="col-sm-2 control-label">Rate per 1000</label>
			                                    	<div class="col-sm-4">
														<form:input path="ratePer1000" name="ratePer1000" id="ratePer1000" class="form-control" placeholder="Rate per 1000" />
													</div>
												</div>
												<div class="form-group">
													<label for="rateOfLeaf" class="col-sm-2 control-label">Rate of Leaf</label>
			                                    	<div class="col-sm-4">
														<form:input path="rateOfLeaf" name="rateOfLeaf" id="rateOfLeaf" class="form-control" placeholder="Rate of Leaf" />
													</div>
												</div>
												<div class="form-group">
													<label for="rateOfTobacco" class="col-sm-2 control-label">Rate of Tobacco</label>
			                                    	<div class="col-sm-4">
														<form:input path="rateOfTobacco" id="rateOfTobacco" name="rateOfTobacco" class="form-control" placeholder="Rate of Tobacco" />
													</div>
												</div>
												<div class="form-group">
													<div class="col-sm-3">&nbsp;</div>
			                                    	<div class="col-sm-4">
														<button type="submit" class="btn btn-default">Add</button>
														<button type="reset" class="btn btn-primary">Reset</button>
													</div>
												</div>
											</form:form>
										</c:when>
										<c:otherwise>
											<c:if test="${result == 'success'}">
												<div class="form-group has-success">
													<label class="col-sm-4 control-label" for="inputSuccess">${msg}</label>
												</div>
											</c:if>
											<c:if test="${result == 'error'}">
												<div class="form-group has-error">
													<label class="col-sm-4 control-label" for="inputError">${msg}</label>
												</div>
											</c:if>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>