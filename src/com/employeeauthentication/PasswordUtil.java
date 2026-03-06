package com.employeeauthentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * This class handles password hashing
 */

public class PasswordUtil {
	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder();
		for (byte h : hash) {
			hexString.append(String.format("%02x", h));
		}
		return hexString.toString();
	}
	
	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			final byte[] hash = md.digest(password.getBytes());
			return bytesToHex(hash);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
