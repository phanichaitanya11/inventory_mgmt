package com.invtmgm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invtmgm.beans.AgentBean;
import com.invtmgm.dao.AgentsDao;

@Service
public class AgentsServiceImpl implements AgentsService {
	
	private static final Logger log = Logger.getLogger(AgentsServiceImpl.class);

	@Autowired
	private AgentsDao agentsDao;
	
	public int addAgent(AgentBean agent) {
		int agentId = 0;
		try {
			agentId = agentsDao.addAgent(agent);
		} catch (Exception e) {
			log.error("An error occurred while adding an agent : " + agent.toString());
			e.printStackTrace();
		}
		return agentId;
	}

	public AgentBean getAgent(int agentId) {
		AgentBean bean = new AgentBean();
		try {
			bean = agentsDao.getAgent(agentId);
		} catch (Exception e) {
			log.error("An error occurred while fetching agent details for agent id : " + agentId);
			e.printStackTrace();
		}
		return bean;
	}
	
	public AgentBean updateAgent(AgentBean bean) {
		AgentBean agent = new AgentBean();
		try {
			agent = agentsDao.updateAgent(bean);
		} catch (Exception e) {
			log.error("An error occurred while updating agent details : " + bean.toString());
			e.printStackTrace();
		}
		return agent;
	}
	
	public boolean deleteAgent(int agentId) {
		boolean isDeleted = false;
		try {
			isDeleted = agentsDao.deleteAgent(agentId);
		} catch (Exception e) {
			log.error("An error occurred while deleting an agent : " + agentId);
			e.printStackTrace();
		}
		return isDeleted;
	}
	
	public List<AgentBean> getAgentsList() {
		List<AgentBean> agentsList = new ArrayList<AgentBean>();
		try {
			agentsList = agentsDao.getAgentsList();
		} catch (Exception e) {
			log.error("Error occurred while fetching agents list");
			e.printStackTrace();
		}
		return agentsList;
	}
}
