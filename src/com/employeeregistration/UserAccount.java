package com.employeeregistration;

import com.employeeauthentication.PasswordUtil;

/*
 * This class represents login related information
 */

public class UserAccount {
	private String loginId;
	private String password;
	
	public UserAccount(String loginId, String password) {
		this.loginId = loginId;
		this.password = PasswordUtil.hashPassword(password);
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public void setPassword(String password) {
		this.password = PasswordUtil.hashPassword(password);
	}
}
