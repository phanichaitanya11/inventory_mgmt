package com.invtmgm.service;

import java.util.List;

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
		int tranId = dailyTranDao.addNewIncomingTran(tranBean);
		double cost = calculateCost(tranBean);
		// Update the agent balance with negative value because this is the
		// amount that we have to pay to the agent.
		if (cost > 0) {
			agentBalanceService.updateAgentBalance(tranBean.getAgentId(), -cost);
		}
		return tranId;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int addNewOutgoingTran(DailyTranBean tranBean) {
		int transactionId = dailyTranDao.addNewOutgoingTran(tranBean);
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
		return transactionId;
	}

	public List<DailyTranBean> getTransactionsList() {
		return dailyTranDao.getTransactionsList();
	}
	
	private double calculateCost(DailyTranBean tranBean) {
		double cost = 0;
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
		return cost;
	}
	
	public List<DailyTranBean> getTransactionsListForAgent(int agentId) {
		return dailyTranDao.getTransactionsListForAgent(agentId);
	}
	
	public int getNoOfApprovedPdtsForCurrentMonth(int agentId) {
		return dailyTranDao.getNoOfApprovedPdtsForCurrentMonth(agentId);
	}
}
