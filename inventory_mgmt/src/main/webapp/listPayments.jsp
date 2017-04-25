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
                            List of Payments made
                        </div>
						<div class="panel-body">
							<c:choose>
								<c:when test="${empty paymentsList}">
									<div class="form-group has-error">
										<label class="control-label" for="inputError"><h3>Nothing to show here right now. Make a payment and come back.</h3></label>
									</div>
								</c:when>
								<c:otherwise>
									<div class="table-responsive">
		                                <table class="table table-striped table-bordered table-hover" id="paymentsList-tables">
		                                	<thead>
		                                        <tr>
		                                        	<th>Payment ID</th>
		                                            <th>Agent ID</th>
		                                            <th>Agent Name</th>
		                                            <th>Payment Date</th>
		                                            <th>Amount</th>
		                                            <th>Is Advance?</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
			                                    <c:forEach items="${paymentsList}" var="pay">
			                                    	<tr class="gradeA">
			                                           <td>${pay.paymentId}</td>
			                                           <td>${pay.agentId}</td>
			                                           <td>${pay.agentName}</td>
			                                           <td>${pay.paymentDateStr}</td>
			                                           <td>${pay.amount}</td>
			                                           <td>${pay.advancePay}</td>
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
		    $('#paymentsList-tables').dataTable();
		});
	</script>
</body>
</html>