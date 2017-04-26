package com.invtmgm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invtmgm.dao.AgentBalanceDao;

@Service
public class AgentBalanceServiceImpl implements AgentBalanceService {

	private static final Logger log = Logger.getLogger(AgentBalanceServiceImpl.class);
	
	@Autowired
	private AgentBalanceDao agentBalanceDao;
	
	public void updateAgentBalance(int agentId, double bal) {
		try {
			agentBalanceDao.updateAgentBalance(agentId, bal);
		} catch (Exception e) {
			log.error("An error occurred while updating balance for an agent : " + agentId + ", balance : " + bal);
			e.printStackTrace();
		}
	}
	
	public double getAgentBalance(int agentId) {
		double bal = 0;
		try {
			agentBalanceDao.getAgentBalance(agentId);
		} catch (Exception e) {
			log.error("An error occurred while fetching agent balance for agent id : " + agentId);
			e.printStackTrace();
		}
		return bal;
	}
}
