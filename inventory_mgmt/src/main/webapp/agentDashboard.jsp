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
									<form:form method="POST" name="searchAgentForm" id="searchAgentForm" action="agentDashboard" modelAttribute="viewAgentForm">
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
						<div class="row">
							<div class="col-md-4 col-sm-6 col-xs-6">
								<div class="panel panel-back noti-box">
									<span class="icon-box bg-color-red set-icon"> 
										<i class="fa fa-rupee"></i>
									</span>
									<div class="text-box">
										<c:choose>
											<c:when test="${agentInfo.outstandingBal < 0}">
												<p class="main-text text-danger">${agentInfo.outstandingBal}</p>
											</c:when>
											<c:otherwise>
												<p class="main-text">${agentInfo.outstandingBal}</p>
											</c:otherwise>
										</c:choose>
										<p class="text-muted">Total Outstanding Balance</p>
									</div>
								</div>
							</div>
							
							<div class="col-md-4 col-sm-6 col-xs-6">
								<div class="panel panel-back noti-box">
									<span class="icon-box bg-color-brown set-icon"> 
										<i class="fa fa-rocket"></i>
									</span>
									<div class="text-box">
										<p class="main-text">${noOfApprovedPdts}</p>
										<p class="text-muted">Total Approved Products</p>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<!-- Agent details panel start -->
							<div class="col-md-4">
								<div class="panel panel-primary">
									<div class="panel-heading">
			                            Agent Details
			                        </div>
									<div class="panel-body">
										<form:form class="form-horizontal" modelAttribute="agentInfo">
											<div class="form-group">
	                                            <label for="agentId" class="col-sm-5 control-label">Agent ID</label>
	                                            <div class="col-sm-7 align-bottom">
	                                            	<c:out value="${agentInfo.agentId}"/>
												</div>
	                                        </div>
											<div class="form-group">
												<label for="agentName" class="col-sm-5 control-label">Agent Name</label>
												<div class="col-sm-7">
													<c:out value="${agentInfo.agentName}"/>
												</div>
											</div>
											<div class="form-group">
												<label for="agentName" class="col-sm-5 control-label">Is Temporary? </label>
												<div class="col-sm-7">
													<c:out value="${agentInfo.tempFlag}"/>
												</div>
											</div>
											<div class="form-group">
												<label for="address" class="col-sm-5 control-label">Address</label>
												<div class="col-sm-7">
													<c:out value="${agentInfo.address}"/>
												</div>
											</div>
											<div class="form-group">
												<label for="phoneNum" class="col-sm-5 control-label">Phone Number</label>
		                                    	<div class="col-sm-7">
		                                    		<c:out value="${agentInfo.phoneNum}"/>
												</div>
											</div>
											<div class="form-group">
												<label for="mobileNum" class="col-sm-5 control-label">Mobile Number</label>
		                                    	<div class="col-sm-7">
		                                    		<c:out value="${agentInfo.mobileNum}"/>
												</div>
											</div>
											<div class="form-group">
												<label for="ratePer1000" class="col-sm-5 control-label">Rate per 1000</label>
		                                    	<div class="col-sm-7">
		                                    		<c:out value="${agentInfo.ratePer1000}"/>
												</div>
											</div>
											<div class="form-group">
												<label for="rateOfLeaf" class="col-sm-5 control-label">Rate of Leaf</label>
		                                    	<div class="col-sm-7">
		                                    		<c:out value="${agentInfo.rateOfLeaf}"/>
												</div>
											</div>
											<div class="form-group">
												<label for="rateOfTobacco" class="col-sm-5 control-label">Rate of Tobacco</label>
		                                    	<div class="col-sm-7">
		                                    		<c:out value="${agentInfo.rateOfTobacco}"/>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
							<!-- Agent details panel end -->
							
							<!-- Agent payments panel start -->
							<div class="col-md-8">
								<div class="panel panel-primary">
									<div class="panel-heading">
			                            Payment History
			                        </div>
									<div class="panel-body">
										<c:choose>
											<c:when test="${empty payments}">
												<div class="form-group has-success">
													<label class="control-label" for="inputSuccess"><h3>Nothing to show here right now. Make a payment and come back.</h3></label>
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
						                                    <c:forEach items="${payments}" var="pay">
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
							<!-- Agent payments panel end -->
						</div>
						<div class="row">
							<!-- Agent transactions panel start -->
							<div class="col-md-12">
								<div class="panel panel-primary">
									<div class="panel-heading">
										Transactions History
			                        </div>
									<div class="panel-body">
										<c:choose>
											<c:when test="${empty transactions}">
												<div class="form-group has-success">
													<label class="control-label" for="inputSuccess"><h3>Nothing to show here right now. Make a transaction and come back.</h3></label>
												</div>
											</c:when>
											<c:otherwise>
												<div class="table-responsive">
					                                <table class="table table-striped table-bordered table-hover" id="transactionsList-tables">
					                                	<thead>
					                                        <tr>
					                                        	<th>Transaction ID</th>
																<th>Agent ID</th>
																<th>Agent Name</th>
																<th>Date</th>
																<th>Transaction Type</th>
																<th>Total Vol.</th>
																<th>Approved Vol.</th>
																<th>Reject 1 Vol.</th>
																<th>Reject 2 Vol.</th>
																<th>Leaf Issued Vol.</th>
																<th>Tobacco Issued Vol.</th>
																<th>Advanced Cash Paid</th>
					                                        </tr>
					                                    </thead>
					                                    <tbody>
						                                    <c:forEach items="${transactions}" var="tran">
						                                    	<tr class="gradeA">
						                                           <td>${tran.transactionId}</td>
						                                           <td>${tran.agentId}</td>
						                                           <td>${tran.agentName}</td>
						                                           <td>${tran.tranDateStr}</td>
						                                           <td>
						                                           		<c:choose>
						                                           			<c:when test="${tran.tranType eq 'I'}">Incoming</c:when>
						                                           			<c:otherwise>Outgoing</c:otherwise>
						                                           		</c:choose>
						                                           </td>
						                                           <td>
						                                           		<c:if test="${!(tran.totalProdVolume eq 0)}">
								                                           ${tran.totalProdVolume}
								                                   		</c:if>        
								                                   </td>
						                                           <td>
																		<c:if test="${!(tran.approvedVol eq 0)}">
								                                           ${tran.approvedVol}
								                                   		</c:if>       
								                                   </td>
						                                           <td>
						                                           		<c:if test="${!(tran.reject1Vol eq 0)}">
								                                           ${tran.reject1Vol}
								                                   		</c:if>  
						                                           </td>
						                                           <td>
						                                           		<c:if test="${!(tran.reject2Vol eq 0)}">
								                                           ${tran.reject2Vol}
								                                   		</c:if>
						                                           </td>
						                                           <td>
						                                           		<c:if test="${!(tran.leafIssuedVol eq 0)}">
								                                           ${tran.leafIssuedVol}
								                                   		</c:if>
								                                   </td>
						                                           <td>
						                                           		<c:if test="${!(tran.mixTobIssuedVol eq 0)}">
								                                           ${tran.mixTobIssuedVol}
								                                   		</c:if>
								                                   </td>
						                                           <td>
						                                           		<c:if test="${!(tran.advCashPaid eq 0)}">
								                                           ${tran.advCashPaid}
								                                   		</c:if>
						                                           </td>
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
							<!-- Agent transactions panel end -->
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function () {
		    $('#paymentsList-tables').dataTable();
		});
		$(document).ready(function () {
		    $('#transactionsList-tables').dataTable();
		});
	</script>
</body>
</html>