package com.invtmgm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.invtmgm.beans.PaymentBean;
import com.invtmgm.dao.PaymentsDao;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	private static final Logger log = Logger.getLogger(PaymentsServiceImpl.class);
	
	@Autowired
	private PaymentsDao paymentsDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int makePayment(PaymentBean bean) {
		int paymentId = 0;
		try {
			paymentId = paymentsDao.makePayment(bean);
		} catch (Exception e) {
			log.error("Error occurred while making a payment : " + bean.toString());
			e.printStackTrace();
		}
		return paymentId;
	}

	public List<PaymentBean> getPaymentsList() {
		List<PaymentBean> payList = new ArrayList<PaymentBean>();
		try {
			payList = paymentsDao.getPaymentsList();
		} catch (Exception e) {
			log.error("Error occurred while fetching list of payments ");
			e.printStackTrace();
		}
		return payList;
	}

	public List<PaymentBean> getPaymentsListForAgent(int agentId) {
		List<PaymentBean> payList = new ArrayList<PaymentBean>();
		try {
			payList = paymentsDao.getPaymentsListForAgent(agentId);
		} catch (Exception e) {
			log.error("Error occurred while fetching list of payments for an agent : " + agentId);
			e.printStackTrace();
		}
		return payList;
	}
}
