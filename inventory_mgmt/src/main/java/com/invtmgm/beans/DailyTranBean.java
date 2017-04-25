package com.invtmgm.beans;

import java.io.Serializable;
import java.util.Date;

import com.invtmgm.utils.Utils;

public class DailyTranBean implements Serializable {

	private static final long serialVersionUID = -795748519427974407L;

	private int agentId;
	
	private long transactionId;
	
	private Date tranDate;
	
	private String tranType;
	
	private String agentName;
	
	private double totalProdVolume;
	
	private double approvedVol;
	
	private double reject1Vol;
	
	private double reject2Vol;
	
	private double leafIssuedVol;
	
	private double mixTobIssuedVol;
	
	private double advCashPaid;

	private long paymentId;
	
	/**
	 * @return the advCashPaid
	 */
	public double getAdvCashPaid() {
		return advCashPaid;
	}

	/**
	 * @return the agentId
	 */
	public int getAgentId() {
		return agentId;
	}

	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @return the approvedVol
	 */
	public double getApprovedVol() {
		return approvedVol;
	}

	/**
	 * @return the leafIssuedVol
	 */
	public double getLeafIssuedVol() {
		return leafIssuedVol;
	}

	/**
	 * @return the mixTobIssuedVol
	 */
	public double getMixTobIssuedVol() {
		return mixTobIssuedVol;
	}

	/**
	 * @return the paymentId
	 */
	public long getPaymentId() {
		return paymentId;
	}

	/**
	 * @return the reject1Vol
	 */
	public double getReject1Vol() {
		return reject1Vol;
	}

	/**
	 * @return the reject2Vol
	 */
	public double getReject2Vol() {
		return reject2Vol;
	}

	/**
	 * @return the totalProdVolume
	 */
	public double getTotalProdVolume() {
		return totalProdVolume;
	}

	/**
	 * @return the tranDate
	 */
	public Date getTranDate() {
		return tranDate;
	}

	/**
	 * @return the transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * @return the tranType
	 */
	public String getTranType() {
		return tranType;
	}

	/**
	 * @param advCashPaid the advCashPaid to set
	 */
	public void setAdvCashPaid(double advCashPaid) {
		this.advCashPaid = advCashPaid;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * @param approvedVol the approvedVol to set
	 */
	public void setApprovedVol(double approvedVol) {
		this.approvedVol = approvedVol;
	}

	/**
	 * @param leafIssuedVol the leafIssuedVol to set
	 */
	public void setLeafIssuedVol(double leafIssuedVol) {
		this.leafIssuedVol = leafIssuedVol;
	}

	/**
	 * @param mixTobIssuedVol the mixTobIssuedVol to set
	 */
	public void setMixTobIssuedVol(double mixTobIssuedVol) {
		this.mixTobIssuedVol = mixTobIssuedVol;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @param reject1Vol the reject1Vol to set
	 */
	public void setReject1Vol(double reject1Vol) {
		this.reject1Vol = reject1Vol;
	}

	/**
	 * @param reject2Vol the reject2Vol to set
	 */
	public void setReject2Vol(double reject2Vol) {
		this.reject2Vol = reject2Vol;
	}

	/**
	 * @param totalProdVolume the totalProdVolume to set
	 */
	public void setTotalProdVolume(double totalProdVolume) {
		this.totalProdVolume = totalProdVolume;
	}

	/**
	 * @param tranDate the tranDate to set
	 */
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @param tranType the tranType to set
	 */
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	
	/**
	 * @return the getTranDateStr
	 */
	public String getTranDateStr() {
		return Utils.parseDateToString(tranDate);
	}

	@Override
	public String toString() {
		return "DailyTranBean [agentId=" + agentId + ", transactionId="
				+ transactionId + ", tranDate=" + tranDate + ", tranType="
				+ tranType + ", agentName=" + agentName + ", totalProdVolume="
				+ totalProdVolume + ", approvedVol=" + approvedVol
				+ ", reject1Vol=" + reject1Vol + ", reject2Vol=" + reject2Vol
				+ ", leafIssuedVol=" + leafIssuedVol + ", mixTobIssuedVol="
				+ mixTobIssuedVol + ", advCashPaid=" + advCashPaid
				+ ", paymentId=" + paymentId + "]";
	}
}
