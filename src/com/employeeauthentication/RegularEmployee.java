package com.employeeauthentication;

public class RegularEmployee extends User {
	public RegularEmployee(String username, String password) {
		super(username, password, "EMPLOYEE");
	}
	
	@Override
	public boolean authenticate(String username, String password) {
		if (this.username.equals(username)) {
			if (this.passwordHash.equals(PasswordUtil.hashPassword(password))) {
				return true;
			}
		}
		return false;
	}
}
