package com.invtmgm.beans;

import java.io.Serializable;

public class AgentBean implements Serializable {

	private static final long serialVersionUID = -8646241593661226820L;

	private int agentId;

	private String agentName;

	private String address;

	private String phoneNum;

	private String mobileNum;

	private boolean tempFlag;

	private Float ratePer1000;

	private Float rateOfLeaf;

	private Float rateOfTobacco;
	
	private double outstandingBal;

	public AgentBean() {
		super();
	}
	
	public AgentBean(int agentId, String agentName, String address,
			String phoneNum, String mobileNum, boolean tempFlag,
			Float ratePer1000, Float rateOfLeaf, Float rateOfTobacco,
			double outstandingBal) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.address = address;
		this.phoneNum = phoneNum;
		this.mobileNum = mobileNum;
		this.tempFlag = tempFlag;
		this.ratePer1000 = ratePer1000;
		this.rateOfLeaf = rateOfLeaf;
		this.rateOfTobacco = rateOfTobacco;
		this.outstandingBal = outstandingBal;
	}

	/**
	 * @return the agentId
	 */
	public int getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId
	 *            the agentId to set
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @param agentName
	 *            the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the tempFlag
	 */
	public boolean isTempFlag() {
		return tempFlag;
	}

	/**
	 * @param tempFlag
	 *            the tempFlag to set
	 */
	public void setTempFlag(boolean tempFlag) {
		this.tempFlag = tempFlag;
	}


	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return the mobileNum
	 */
	public String getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	/**
	 * @return the ratePer1000
	 */
	public Float getRatePer1000() {
		return ratePer1000;
	}

	/**
	 * @param ratePer1000 the ratePer1000 to set
	 */
	public void setRatePer1000(Float ratePer1000) {
		this.ratePer1000 = ratePer1000;
	}

	/**
	 * @return the rateOfLeaf
	 */
	public Float getRateOfLeaf() {
		return rateOfLeaf;
	}

	/**
	 * @param rateOfLeaf the rateOfLeaf to set
	 */
	public void setRateOfLeaf(Float rateOfLeaf) {
		this.rateOfLeaf = rateOfLeaf;
	}

	/**
	 * @return the rateOfTobacco
	 */
	public Float getRateOfTobacco() {
		return rateOfTobacco;
	}

	/**
	 * @param rateOfTobacco the rateOfTobacco to set
	 */
	public void setRateOfTobacco(Float rateOfTobacco) {
		this.rateOfTobacco = rateOfTobacco;
	}

	/**
	 * @return the outstandingBal
	 */
	public double getOutstandingBal() {
		return outstandingBal;
	}

	/**
	 * @param outstandingBal the outstandingBal to set
	 */
	public void setOutstandingBal(double outstandingBal) {
		this.outstandingBal = outstandingBal;
	}

	@Override
	public String toString() {
		return "AgentBean [agentId=" + agentId + ", agentName=" + agentName
				+ ", address=" + address + ", phoneNum=" + phoneNum
				+ ", mobileNum=" + mobileNum + ", tempFlag=" + tempFlag
				+ ", ratePer1000=" + ratePer1000 + ", rateOfLeaf=" + rateOfLeaf
				+ ", rateOfTobacco=" + rateOfTobacco + ", outstandingBal="
				+ outstandingBal + "]";
	}
}
