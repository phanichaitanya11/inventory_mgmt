package com.invtmgm.service;

public interface AgentBalanceService {

	public void updateAgentBalance(int agentId, double bal);

	public double getAgentBalance(int agentId);

}