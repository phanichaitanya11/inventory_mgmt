<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li class="text-center"><br /><br /><br /></li>
				<li>
                	<a href="agentDashboard"><i class="fa fa-dashboard fa-3x"></i>Agent Dashboard</a>
                </li>
				<li>
					<a href="#"> 
						<i class="fa fa-sitemap fa-3x"></i>Agents<span class="fa arrow"></span>
					</a>
					<ul class="nav nav-second-level">
						<li><a href="listAgents">List Agents</a></li>
						<li><a href="viewAgent">View Agent</a></li>
						<li><a href="addAgent">Add Agent</a></li>
						<li><a href="searchAgent">Delete Agent</a></li>
					</ul>
				</li>
				<li>
					<a href="#"> 
						<i class="fa fa-money fa-3x"></i>Payments<span class="fa arrow"></span>
					</a>
					<ul class="nav nav-second-level">
						<li><a href="newPayment">Make Payment</a></li>
						<li><a href="listPayments">Payment History</a></li>
					</ul>
				</li>
				<li>
					<a href="#"> 
						<i class="fa fa-tasks fa-3x"></i>Daily Transactions<span class="fa arrow"></span>
					</a>
					<ul class="nav nav-second-level">
						<li><a href="incomingTran">Incoming Transaction</a></li>
						<li><a href="outgoingTran">Outgoing Transaction</a></li>
						<li><a href="listTransactions">List All Transactions</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<!-- /. NAV SIDE  -->
</body>
</html>