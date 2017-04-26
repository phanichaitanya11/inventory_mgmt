package com.invtmgm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.invtmgm.beans.AgentBean;
import com.invtmgm.beans.DailyTranBean;
import com.invtmgm.beans.PaymentBean;
import com.invtmgm.dao.DailyTranDao;

@Service
public class DailyTranServiceImpl implements DailyTranService {

	private static final Logger log = Logger.getLogger(DailyTranServiceImpl.class);
	
	@Autowired
	private DailyTranDao dailyTranDao;
	
	@Autowired
	private AgentsService agentsService;
	
	@Autowired
	private PaymentsService paymentsService;
	
	@Autowired
	private AgentBalanceService agentBalanceService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int addNewIncomingTran(DailyTranBean tranBean) {
		int tranId = 0;
		try {
			tranId = dailyTranDao.addNewIncomingTran(tranBean);
			double cost = calculateCost(tranBean);
			// Update the agent balance with negative value because this is the
			// amount that we have to pay to the agent.
			if (cost > 0) {
				agentBalanceService.updateAgentBalance(tranBean.getAgentId(), -cost);
			}
		} catch (Exception e) {
			log.error("An error has occurred while adding a new incoming transaction : " + tranBean.toString());
			e.printStackTrace();
		}
		return tranId;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int addNewOutgoingTran(DailyTranBean tranBean) {
		int transactionId = 0;
		try {
			transactionId  = dailyTranDao.addNewOutgoingTran(tranBean);
			if (tranBean.getAdvCashPaid() > 0) {
				PaymentBean payBean = new PaymentBean();
				payBean.setAdvancePay(true);
				payBean.setAgentId(tranBean.getAgentId());
				payBean.setAmount(tranBean.getAdvCashPaid());
				payBean.setPaymentDate(tranBean.getTranDate());
				int paymentId = paymentsService.makePayment(payBean);
				dailyTranDao.updatePaymentIdForOutgoingTran(paymentId, transactionId);
			}
			double cost = calculateCost(tranBean);
			// Update the agent balance with positive value because this is the
			// amount that agent have to pay us.
			if (cost > 0) {
				agentBalanceService.updateAgentBalance(tranBean.getAgentId(), cost);
			}
		} catch (Exception e) {
			log.error("An error occurred while adding a new outgoing transaction : " + tranBean.toString());
			e.printStackTrace();
		}
		return transactionId;
	}

	public List<DailyTranBean> getTransactionsList() {
		List<DailyTranBean> transList = new ArrayList<DailyTranBean>();
		try {
			transList = dailyTranDao.getTransactionsList();
		} catch (Exception e) {
			log.error("Error occurred while fetching list of transactions");
			e.printStackTrace();
		}
		return transList;
	}
	
	private double calculateCost(DailyTranBean tranBean) {
		double cost = 0;
		try {
			if (tranBean != null) {
				int agentId = tranBean.getAgentId();
				AgentBean agent = agentsService.getAgent(agentId);
				if (agent != null) {
					if ("O".equalsIgnoreCase(tranBean.getTranType())) {
						cost = (tranBean.getLeafIssuedVol() * agent.getRateOfLeaf()) + (tranBean.getMixTobIssuedVol() * agent.getRateOfTobacco());
						if (tranBean.getAdvCashPaid() > 0) {
							cost = cost - tranBean.getAdvCashPaid();
						}
					} else if ("I".equalsIgnoreCase(tranBean.getTranType())) {
						cost = (tranBean.getApprovedVol()/1000) * agent.getRatePer1000();
					}
				}
			}
		} catch (Exception e) {
			log.error("An error occurred while calculating cost for a transaction : " + tranBean.toString());
			e.printStackTrace();
		}
		return cost;
	}
	
	public List<DailyTranBean> getTransactionsListForAgent(int agentId) {
		List<DailyTranBean> transList = new ArrayList<DailyTranBean>();
		try {
			transList = dailyTranDao.getTransactionsListForAgent(agentId);
		} catch (Exception e) {
			log.error("Error occurred while fetching list of transactions for a particular agent");
			e.printStackTrace();
		}
		return transList;
	}
	
	public int getNoOfApprovedPdtsForCurrentMonth(int agentId) {
		int totalPdts = 0;
		try {
			totalPdts = dailyTranDao.getNoOfApprovedPdtsForCurrentMonth(agentId);
		} catch (Exception e) {
			log.error("Error occurred while fetching total number of approved products for a current month for an agent : " + agentId);
			e.printStackTrace();
		}
		return totalPdts;
	}
}
