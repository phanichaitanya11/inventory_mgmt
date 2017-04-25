package com.invtmgm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean validateUser(String uname, String pwd) {
		String sql = "select password from users where user_name = ? and active_flag = Yes";
		String password = (String)jdbcTemplate.queryForObject(sql, new Object[] {uname}, String.class);
		if (pwd.equals(password)) {
			return true;
		}
		return false;
	}

}
