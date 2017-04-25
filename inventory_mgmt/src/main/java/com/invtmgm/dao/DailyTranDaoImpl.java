package com.invtmgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.invtmgm.beans.DailyTranBean;
import com.invtmgm.utils.Utils;

@Repository
public class DailyTranDaoImpl implements DailyTranDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addNewIncomingTran(final DailyTranBean tranBean) {
		int retVal = 0;
		final String sql = "Insert into daily_tran "
				+ "(agent_id, tran_dt, tran_type, total_vol_bought, approved_pdt_vol, reject1_vol, reject2_vol, updated_by) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, tranBean.getAgentId());
				ps.setDate(2, Utils.getSqlDate(tranBean.getTranDate()));
				ps.setString(3, "I"); // "I" for incoming
				ps.setDouble(4, tranBean.getTotalProdVolume());
				ps.setDouble(5, tranBean.getApprovedVol());
				ps.setDouble(6, tranBean.getReject1Vol());
				ps.setDouble(7, tranBean.getReject2Vol());
				ps.setString(8, "admin");
				return ps;
			}
		}, keyHolder);
		retVal = keyHolder.getKey().intValue();
		return retVal;
	}
	
	public int addNewOutgoingTran(final DailyTranBean tranBean) {
		int retVal = 0;
		final String sql = "Insert into daily_tran "
				+ "(agent_id, tran_dt, tran_type, leaf_issued_vol, tobacco_issued_vol, updated_by) "
				+ "values (?, ?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, tranBean.getAgentId());
				ps.setDate(2, Utils.getSqlDate(tranBean.getTranDate()));
				ps.setString(3, "O"); // "O" for incoming
				ps.setDouble(4, tranBean.getLeafIssuedVol());
				ps.setDouble(5, tranBean.getMixTobIssuedVol());
				ps.setString(6, "admin");
				return ps;
			}
		}, keyHolder);
		retVal = keyHolder.getKey().intValue();
		return retVal;
	}
	
	public void updatePaymentIdForOutgoingTran(int paymentId, int transactionId) {
		final String sql = "Update daily_tran set payment_id = ? where tran_id = ?";
		Object[] args = new Object[] {paymentId, transactionId};
		jdbcTemplate.update(sql, args);
	}
	
	public List<DailyTranBean> getTransactionsList() {
		List<DailyTranBean> transactionsList = new ArrayList<DailyTranBean>();
		try {
			String sql = "select a.tran_id as transactionId, a.agent_id as agentId, a.tran_dt as tranDate, COALESCE(a.total_vol_bought, 0) as totalProdVolume, "
					+ "COALESCE(a.approved_pdt_vol, 0) as approvedVol, COALESCE(a.reject1_vol, 0) as reject1Vol, COALESCE(a.reject2_vol, 0) as reject2Vol, "
					+ "COALESCE(a.leaf_issued_vol, 0) as leafIssuedVol, COALESCE(a.tobacco_issued_vol, 0) as mixTobIssuedVol, a.tran_type as tranType, "
					+ "b.agent_name as agentName, COALESCE(c.amount, 0) as advCashPaid "
					+ "from daily_tran a left join agents b on  a.agent_id = b.agent_id "
					+ "left join payments c on a.agent_id = c.agent_id and a.payment_id = c.payment_id";
			transactionsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DailyTranBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionsList;
	}
	
	public List<DailyTranBean> getTransactionsListForAgent(int agentId) {
		List<DailyTranBean> transactionsList = new ArrayList<DailyTranBean>();
		try {
			String sql = "select a.tran_id as transactionId, a.agent_id as agentId, a.tran_dt as tranDate, COALESCE(a.total_vol_bought, 0) as totalProdVolume, "
					+ "COALESCE(a.approved_pdt_vol, 0) as approvedVol, COALESCE(a.reject1_vol, 0) as reject1Vol, COALESCE(a.reject2_vol, 0) as reject2Vol, "
					+ "COALESCE(a.leaf_issued_vol, 0) as leafIssuedVol, COALESCE(a.tobacco_issued_vol, 0) as mixTobIssuedVol, a.tran_type as tranType, "
					+ "b.agent_name as agentName, COALESCE(c.amount, 0) as advCashPaid "
					+ "from daily_tran a left join agents b on  a.agent_id = b.agent_id "
					+ "left join payments c on a.agent_id = c.agent_id and a.payment_id = c.payment_id where a.agent_id = " + agentId;
			transactionsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(DailyTranBean.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionsList;
	}
	
	public int getNoOfApprovedPdtsForCurrentMonth(int agentId) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		Date monthStartDt = cal.getTime();
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date monthEndDt = cal.getTime();
		String sql = "select sum(approved_pdt_vol) from daily_tran where agent_id = ? and tran_dt >= ? and ? >= tran_dt";
		Object[] args = new Object[] {agentId, Utils.getSqlDate(monthStartDt), Utils.getSqlDate(monthEndDt)};
		int noOfPdts = jdbcTemplate.queryForInt(sql, args);
		return noOfPdts;
	}
}
