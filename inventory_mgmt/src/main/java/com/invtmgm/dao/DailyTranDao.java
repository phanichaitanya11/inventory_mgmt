package com.invtmgm.dao;

import java.util.List;

import com.invtmgm.beans.DailyTranBean;

public interface DailyTranDao {

	public int addNewIncomingTran(DailyTranBean tranBean);

	public int addNewOutgoingTran(DailyTranBean tranBean);

	public List<DailyTranBean> getTransactionsList();
	
	public void updatePaymentIdForOutgoingTran(int paymentId, int transactionId);
	
	public List<DailyTranBean> getTransactionsListForAgent(int agentId);
	
	public int getNoOfApprovedPdtsForCurrentMonth(int agentId);
}