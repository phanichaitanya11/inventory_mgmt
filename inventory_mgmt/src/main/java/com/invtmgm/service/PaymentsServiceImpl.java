package com.invtmgm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.invtmgm.beans.PaymentBean;
import com.invtmgm.dao.PaymentsDao;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsDao paymentsDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int makePayment(PaymentBean bean) {
		int paymentId = paymentsDao.makePayment(bean);
		return paymentId;
	}

	public List<PaymentBean> getPaymentsList() {
		return paymentsDao.getPaymentsList();
	}

	public List<PaymentBean> getPaymentsListForAgent(int agentId) {
		return paymentsDao.getPaymentsListForAgent(agentId);
	}
}
