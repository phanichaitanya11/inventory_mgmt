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
                            List of Transactions made
                        </div>
						<div class="panel-body">
							<c:choose>
								<c:when test="${empty transactionsList}">
									<div class="form-group has-error">
										<label class="control-label" for="inputError"><h3>Nothing to show here right now. Make a transaction and come back.</h3></label>
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
			                                    <c:forEach items="${transactionsList}" var="tran">
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
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function () {
	    $('#transactionsList-tables').dataTable();
	});
</script>
</body>
</html>