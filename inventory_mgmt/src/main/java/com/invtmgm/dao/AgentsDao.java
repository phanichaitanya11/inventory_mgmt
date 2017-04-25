package com.invtmgm.dao;

import java.util.List;

import com.invtmgm.beans.AgentBean;

public interface AgentsDao {

	public int addAgent(AgentBean agent);
	
	public AgentBean getAgent(int agentId);
	
	public AgentBean updateAgent(AgentBean bean);
	
	public boolean deleteAgent(int agentId);
	
	public List<AgentBean> getAgentsList();
}
