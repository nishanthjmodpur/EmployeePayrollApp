package com.employeeauthentication;


//Session class
public class Session {
	private String username;
	private long loginTime;
	private long timeoutMillis = 300000; // 5 minutes

	public Session(String username) {
		this.username = username;
		this.loginTime = System.currentTimeMillis();
	}

	public boolean isExpired() {
		return System.currentTimeMillis() - loginTime > timeoutMillis;
	}

	@Override
	public String toString() {
		return "Session active for user: " + username;
	}
}