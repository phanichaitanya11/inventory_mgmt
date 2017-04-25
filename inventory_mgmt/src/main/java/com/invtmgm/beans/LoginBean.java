package com.invtmgm.beans;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private static final long serialVersionUID = 6318784617673079343L;

	private String username;
	
	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
