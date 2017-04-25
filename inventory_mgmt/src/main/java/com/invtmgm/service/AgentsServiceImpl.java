package com.invtmgm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invtmgm.beans.AgentBean;
import com.invtmgm.dao.AgentsDao;

@Service
public class AgentsServiceImpl implements AgentsService {

	@Autowired
	private AgentsDao agentsDao;
	
	public int addAgent(AgentBean agent) {
		return agentsDao.addAgent(agent);
	}

	public AgentBean getAgent(int agentId) {
		return agentsDao.getAgent(agentId);
	}
	
	public AgentBean updateAgent(AgentBean bean) {
		return agentsDao.updateAgent(bean);
	}
	
	public boolean deleteAgent(int agentId) {
		return agentsDao.deleteAgent(agentId);
	}
	
	public List<AgentBean> getAgentsList() {
		return agentsDao.getAgentsList();
	}
}
