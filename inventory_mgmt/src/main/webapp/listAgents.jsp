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
                            List of Agents
                        </div>
						<div class="panel-body">
							<c:choose>
								<c:when test="${empty agentsList}">
									<div class="form-group has-error">
										<label class="control-label" for="inputError"><h3>Nothing to show here right now. Add an agent and come back.</h3></label>
									</div>
								</c:when>
								<c:otherwise>
									<div class="table-responsive">
		                                <table class="table table-striped table-bordered table-hover" id="agentsList-tables">
		                                	<thead>
		                                        <tr>
		                                            <th>Agent ID</th>
		                                            <th>Agent Name</th>
		                                            <th class="col-md-3">Address</th>
		                                            <th>Phone No.</th>
		                                            <th>Mobile No.</th>
		                                            <th>Rate of Leaf</th>
		                                            <th>Rate of Tobacco</th>
		                                            <th>Rate per 1000</th>
		                                            <th>Is Temporary</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
			                                    <c:forEach items="${agentsList}" var="agent">
			                                    	<tr class="gradeA">
			                                           <td>${agent.agentId}</td>
			                                           <td>${agent.agentName}</td>
			                                           <td>${agent.address}</td>
			                                           <td>${agent.phoneNum}</td>
			                                           <td>${agent.mobileNum}</td>
			                                           <td>${agent.rateOfLeaf}</td>
			                                           <td>${agent.rateOfTobacco}</td>
			                                           <td>${agent.ratePer1000}</td>
			                                           <td>${agent.tempFlag}</td>
			                                       </tr>
			                                    </c:forEach>
											</tbody>
		                                </table>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function () {
	    $('#agentsList-tables').dataTable();
	});
</script>
</body>
</html>