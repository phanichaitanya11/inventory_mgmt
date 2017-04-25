package com.invtmgm.beans;

import java.io.Serializable;
import java.util.Date;

import com.invtmgm.utils.Utils;

public class PaymentBean implements Serializable {

	private static final long serialVersionUID = 1022771186375791429L;

	private long paymentId;
	
	private int agentId;
	
	private double amount;
	
	private boolean advancePay;
	
	private Date paymentDate;

	private String agentName;
	
	/**
	 * @return the paymentId
	 */
	public long getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the agentId
	 */
	public int getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the advancePay
	 */
	public boolean isAdvancePay() {
		return advancePay;
	}

	/**
	 * @param advancePay the advancePay to set
	 */
	public void setAdvancePay(boolean advancePay) {
		this.advancePay = advancePay;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * @return the paymentDateStr
	 */
	public String getPaymentDateStr() {
		return Utils.parseDateToString(paymentDate);
	}

	@Override
	public String toString() {
		return "PaymentBean [paymentId=" + paymentId + ", agentId=" + agentId
				+ ", amount=" + amount + ", advancePay=" + advancePay
				+ ", paymentDate=" + paymentDate + ", agentName=" + agentName
				+ "]";
	}
}
