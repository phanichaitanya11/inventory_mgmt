package com.invtmgm.dao;

import java.util.List;

import com.invtmgm.beans.PaymentBean;

public interface PaymentsDao {

	public int makePayment(PaymentBean bean);

	public List<PaymentBean> getPaymentsList();
	
	public List<PaymentBean> getPaymentsListForAgent(int agentId);
}
