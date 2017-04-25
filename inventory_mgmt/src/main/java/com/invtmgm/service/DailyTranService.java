package com.invtmgm.service;

import java.util.List;

import com.invtmgm.beans.DailyTranBean;

public interface DailyTranService {

	public abstract int addNewIncomingTran(DailyTranBean tranBean);

	public abstract int addNewOutgoingTran(DailyTranBean tranBean);

	public List<DailyTranBean> getTransactionsList();
	
	public List<DailyTranBean> getTransactionsListForAgent(int agentId);
	
	public int getNoOfApprovedPdtsForCurrentMonth(int agentId);
}