package com.invtmgm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.invtmgm.utils.Utils;

@Repository
public class AgentBalanceDaoImpl implements AgentBalanceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void updateAgentBalance(int agentId, double bal) {
		int id = 0;
		double outstanding = 0;
		String chkSql = "select id, outstanding_bal from agent_balance where agent_id = ?";
		List<Map<String, Object>> results = jdbcTemplate.queryForList(chkSql, new Object[] {agentId});
		if (results != null && !results.isEmpty()) {
			for (Map<String,Object> map : results) {
				id = (Integer) map.get("id");
				outstanding = (Double) map.get("outstanding_bal");	
			}
		}
		if (id > 0) {
			// There is an existing record for this agent
			String updateSql = "update agent_balance set outstanding_bal = ? where id = ? and agent_id = ?";
			Object[] args = new Object[] {Utils.round(bal, 2) + outstanding, id, agentId};
			jdbcTemplate.update(updateSql, args);
		} else {
			String inserSql = "Insert into agent_balance (agent_id, outstanding_bal, updated_by) values (?, ?, ?)";
			Object[] args = new Object[] {agentId, Utils.round(bal, 2), "adming"};
			jdbcTemplate.update(inserSql, args);
		}
	}
	
	public double getAgentBalance(int agentId) {
		double balance = 0;
		String sql = "Select outstanding_bal from agent_balance where agent_id = " + agentId;
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
		if(results != null && !results.isEmpty()) {
			for (Map<String, Object> map : results) {
				balance = (Double) map.get("outstanding_bal");
			}
		}
		return balance;
	}
}
