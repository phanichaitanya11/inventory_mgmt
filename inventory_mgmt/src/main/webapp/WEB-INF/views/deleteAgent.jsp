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
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<!-- Form Elements -->
					<div class="panel panel-primary">
						<div class="panel-heading">
                            Search for Agent Information
                        </div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-6">
									<form:form method="POST" name="searchAgentForm" id="searchAgentForm" action="searchAgent" modelAttribute="viewAgentForm">
										<div class="form-group">
	                                        <div class="input-group">
												<div class="input-group">
		                                            <span class="input-group-addon">Agent ID</span>
		                                            <form:input path="agentId" name="agentId" class="form-control" placeholder="Agent ID" />
		                                        </div>
												<span class="input-group-btn">
													<button class="btn btn-default" type="submit">Search</button>
												</span>
											</div>
										</div>
										<c:if test="${result == 'success'}">
											<div class="form-group has-success">
												<label class="control-label" for="inputSuccess">${msg}</label>
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
					<c:if test="${agentExist}">
						<div class="panel panel-primary">
							<div class="panel-heading">
	                            Agent Details
	                        </div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-10">
										<form:form class="form-horizontal" method="POST" action="deleteAgent" modelAttribute="viewAgentForm">
											<c:if test="${result == 'success'}">
												<div class="form-group has-success">
													<label class="control-label" for="inputSuccess">${msg}</label>
												</div>
											</c:if>
											<c:if test="${result == 'error'}">
												<div class="form-group has-error">
													<label class="control-label" for="inputError">${msg}</label>
												</div>
											</c:if>
											<div class="form-group">
	                                            <label for="agentId" class="col-sm-2 control-label">Agent ID</label>
	                                            <div class="col-sm-5">
												  <form:input id="agentId" path="agentId" name="agentId" class="form-control" placeholder="Agent ID" disabled="true"/>
												</div>
	                                           	<form:hidden path="agentId" name="agentId"/>
	                                        </div>
											<div class="form-group">
												<label for="agentName" class="col-sm-2 control-label">Agent Name</label>
												<div class="col-sm-5">
												  <form:input id="agentName" path="agentName" name="agentName" class="form-control" placeholder="Agent Name" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<label for="tempFlag" class="col-sm-2 control-label">Is Temporary?</label>
												<div class="col-sm-4 checkbox-inline">
	                                                <form:checkbox path="tempFlag" name="tempFlag" disabled="true"/>
	                                            </div>
											</div>
											<div class="form-group">
												<label for="address" class="col-sm-2 control-label">Address</label>
												<div class="col-sm-10">
													<form:textarea id="address" path="address" name="address" class="form-control" placeholder="Address" rows="3" disabled="true"></form:textarea>
												</div>
											</div>
											<div class="form-group">
												<label for="phoneNum" class="col-sm-2 control-label">Phone Number</label>
		                                    	<div class="col-sm-5">
													<form:input path="phoneNum" id="phoneNum" name="phoneNum" class="form-control" placeholder="Phone Number" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<label for="mobileNum" class="col-sm-2 control-label">Mobile Number</label>
		                                    	<div class="col-sm-5">
													<form:input path="mobileNum" id="mobileNum" name="mobileNum" class="form-control" placeholder="Mobile Number" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<label for="ratePer1000" class="col-sm-2 control-label">Rate per 1000</label>
		                                    	<div class="col-sm-5">
													<form:input path="ratePer1000" name="ratePer1000" id="ratePer1000" class="form-control" placeholder="Rate per 1000" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<label for="rateOfLeaf" class="col-sm-2 control-label">Rate of Leaf</label>
		                                    	<div class="col-sm-5">
													<form:input path="rateOfLeaf" name="rateOfLeaf" id="rateOfLeaf" class="form-control" placeholder="Rate of Leaf" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<label for="rateOfTobacco" class="col-sm-2 control-label">Rate of Tobacco</label>
		                                    	<div class="col-sm-5">
													<form:input path="rateOfTobacco" id="rateOfTobacco" name="rateOfTobacco" class="form-control" placeholder="Rate of Tobacco" disabled="true"/>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">&nbsp;</div>
		                                    	<div class="col-sm-5">
													<button type="submit" class="btn btn-default">Delete</button>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>