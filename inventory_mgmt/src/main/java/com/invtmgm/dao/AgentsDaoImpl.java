package com.invtmgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.invtmgm.beans.AgentBean;

@Repository
public class AgentsDaoImpl implements AgentsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addAgent(final AgentBean agent) {
		int retVal = 0;
		final String sql = "Insert into agents (agent_name, address, phone_num, mobile_num, temp_flag, rate_per_1000, rate_of_leaf, rate_of_tobacco, updated_by) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, agent.getAgentName());
				ps.setString(2, agent.getAddress());
				ps.setString(3, agent.getPhoneNum());
				ps.setString(4, agent.getMobileNum());
				ps.setBoolean(5, agent.isTempFlag());
				ps.setFloat(6, agent.getRatePer1000());
				ps.setFloat(7, agent.getRateOfLeaf());
				ps.setFloat(8, agent.getRateOfTobacco());
				ps.setString(9, "admin");
				return ps;
			}
		}, keyHolder);

		retVal = keyHolder.getKey().intValue();
		return retVal;
	}

	public AgentBean getAgent(int agentId) {
		AgentBean bean = null;
		try {
			String sql = "select * from agents where agent_id = ?";
			Object[] args = new Object[] { agentId };
			bean = jdbcTemplate.queryForObject(sql, new AgentRowMapper(), args);
		} catch (EmptyResultDataAccessException er) {
			return null;
		}
		return bean;
	}

	public AgentBean updateAgent(AgentBean bean) {
		AgentBean updatedBean = new AgentBean();
		String sql = "update agents set agent_name = ?, address = ? , phone_num = ?, mobile_num = ?, temp_flag = ?, rate_per_1000 = ?, rate_of_leaf = ?, rate_of_tobacco = ?"
				+ " where agent_id = ?";
		Object[] args = new Object[] { bean.getAgentName(), bean.getAddress(), bean.getPhoneNum(), bean.getMobileNum(), bean.isTempFlag(), 
				bean.getRatePer1000(), bean.getRateOfLeaf(), bean.getRateOfTobacco(), bean.getAgentId()};
		int rowsUpdated = jdbcTemplate.update(sql, args);
		if (rowsUpdated != 0) {
			updatedBean = getAgent(bean.getAgentId());
		}
		return updatedBean;
	}
	
	public boolean deleteAgent(int agentId) {
		boolean deleteSuccess = false;
		String sql = "delete from agents where agent_id = ?";
		Object[] args = new Object[] {agentId};
		int rowsUpdated = jdbcTemplate.update(sql, args);
		if (rowsUpdated != 0) {
			deleteSuccess = true;
		} else {
			deleteSuccess = false;
		}
		return deleteSuccess;
	}

	public List<AgentBean> getAgentsList() {
		List<AgentBean> agentsList = new ArrayList<AgentBean>();
		String sql = "select agent_id as agentId, agent_name as agentName, address, phone_num as phoneNum, mobile_num as mobileNum, temp_flag as tempFlag,"
				+ " rate_of_leaf as rateOfLeaf, rate_of_tobacco as rateOfTobacco, rate_per_1000 as ratePer1000 from agents";
		agentsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(AgentBean.class));
		return agentsList;
	}

	class AgentRowMapper implements RowMapper<AgentBean> {
		public AgentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			AgentBean bean = new AgentBean();
			bean.setAddress(rs.getString("address"));
			bean.setAgentId(rs.getInt("agent_id"));
			bean.setAgentName(rs.getString("agent_name"));
			bean.setPhoneNum(rs.getString("phone_num"));
			bean.setMobileNum(rs.getString("mobile_num"));
			bean.setTempFlag(rs.getBoolean("temp_flag"));
			bean.setRatePer1000(rs.getFloat("rate_per_1000"));
			bean.setRateOfLeaf(rs.getFloat("rate_of_leaf"));
			bean.setRateOfTobacco(rs.getFloat("rate_of_tobacco"));
			return bean;
		}
	}
}
