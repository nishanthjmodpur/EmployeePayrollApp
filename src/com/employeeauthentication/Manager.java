package com.employeeauthentication;

//Manager subclass
public class Manager extends User {
	public Manager(String username, String password) {
	   super(username, password, "MANAGER");
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