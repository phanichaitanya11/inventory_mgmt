package com.invtmgm.dao;

public interface AgentBalanceDao {

	public void updateAgentBalance(int agentId, double bal);
	
	public double getAgentBalance(int agentId);

}