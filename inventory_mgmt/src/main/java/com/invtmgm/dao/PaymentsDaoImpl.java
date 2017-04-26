package com.invtmgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.invtmgm.beans.PaymentBean;
import com.invtmgm.utils.Utils;

@Repository
public class PaymentsDaoImpl implements PaymentsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int makePayment(final PaymentBean bean) {
		int retVal = 0;
		final String sql = "Insert into payments (agent_id, payment_date, amount, is_advance, updated_by) values (?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, bean.getAgentId());
				ps.setDate(2, Utils.getSqlDate(bean.getPaymentDate()));
				ps.setDouble(3, bean.getAmount());
				ps.setBoolean(4, bean.isAdvancePay());
				ps.setString(5, "admin");
				return ps;
			}
		}, keyHolder);

		retVal = keyHolder.getKey().intValue();
		return retVal;
	}
	
	public List<PaymentBean> getPaymentsList() {
		List<PaymentBean> paymentsList = new ArrayList<PaymentBean>();
		String sql = "select a.payment_id as paymentId, a.agent_id as agentId, a.payment_date as paymentDate, a.amount as amount, "
				+ "a.is_advance as advancePay, b.agent_name as agentName from payments a, agents b where a.agent_id = b.agent_id";
		paymentsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PaymentBean.class));
		return paymentsList;
	
	}
	
	public List<PaymentBean> getPaymentsListForAgent(int agentId) {
		List<PaymentBean> paymentsList = new ArrayList<PaymentBean>();
		String sql = "select a.payment_id as paymentId, a.agent_id as agentId, a.payment_date as paymentDate, a.amount as amount, "
				+ "a.is_advance as advancePay, b.agent_name as agentName from payments a, agents b where a.agent_id = b.agent_id "
				+ "and a.agent_id = " + agentId;
		paymentsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PaymentBean.class));
		return paymentsList;
	}
}
