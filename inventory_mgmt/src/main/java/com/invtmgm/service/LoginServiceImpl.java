package com.invtmgm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invtmgm.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public boolean validateUser(String uname, String pwd) {
		return loginDao.validateUser(uname, pwd);
	}
}
