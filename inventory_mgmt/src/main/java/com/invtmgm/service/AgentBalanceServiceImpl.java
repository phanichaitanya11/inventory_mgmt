package com.invtmgm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invtmgm.dao.AgentBalanceDao;

@Service
public class AgentBalanceServiceImpl implements AgentBalanceService {

	@Autowired
	private AgentBalanceDao agentBalanceDao;
	
	public void updateAgentBalance(int agentId, double bal) {
		agentBalanceDao.updateAgentBalance(agentId, bal);
	}
	
	public double getAgentBalance(int agentId) {
		return agentBalanceDao.getAgentBalance(agentId);
	}
}
