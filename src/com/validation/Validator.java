package com.validation;

import java.util.regex.Pattern;

public class Validator {

	// Sanitizes input before validation
	private static String sanitize(String input) {
		return input == null ? "" : input.trim();
	}

	/**
	 * Checks whether an email follows a valid format.
	 * 
	 * If the format is wrong: - A validation Exception is thrown - Program flow
	 * jumps to catch block
	 */
	public static void validateEmail(String email) throws ValidationException {
		if (!Pattern.matches("[A-Za-z0-9+_.-]+@(.+)$", email)) {
			throw new ValidationException("Invalid email format");
		}
	}

	/*
	 * Validates Indian Phone numbers.
	 * 
	 * Rule: - Must start with 6,7,8,9 - Must be exactly 10 digits
	 */
	public static void validatePhone(String phone) throws ValidationException {
		if (!Pattern.matches("^[6-9][0-9]{9}$", phone)) {
			throw new ValidationException("Invalid Phone number format");
		}
	}

	/*
	 * Validates Employee ID format Rule: - Must follow EMP-XXXX where X is a digit
	 */
	public static void validateEmployeeId(String employeeId) throws ValidationException {
		if (!Pattern.matches("^EMP-\\d{4}$", employeeId)) {
			throw new ValidationException("Invalid Employee ID format");
		}
	}

	public static void validatePassword(String password) throws ValidationException {
		password = sanitize(password);
		// At least 8 chars, one uppercase, one lowercase, one digit, one special char
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
		if (!Pattern.matches(regex, password)) {
			throw new ValidationException(
					"Weak password. Must be 8+ chars with uppercase, lowercase, digit, and special character.");
		}
	}

}