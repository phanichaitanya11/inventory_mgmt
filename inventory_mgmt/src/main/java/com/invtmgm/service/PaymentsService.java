package com.invtmgm.service;

import java.util.List;

import com.invtmgm.beans.PaymentBean;

public interface PaymentsService {

	public int makePayment(PaymentBean bean);

	public List<PaymentBean> getPaymentsList();
	
	public List<PaymentBean> getPaymentsListForAgent(int agentId);
}
