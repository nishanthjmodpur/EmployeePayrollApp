package com.validation;

import java.util.regex.Pattern;

public class Validator {
	/**
	 * Checks whether an email follows a valid format.
	 * 
	 * If the format is wrong:
	 * 	- A validation Exception is thrown
	 *  - Program flow jumps to catch block
	 */
	public static void validateEmail(String email) throws ValidationException {
		if (!Pattern.matches("[A-Za-z0-9+_.-]+@(.+)$", email)) {
			throw new ValidationException("Invalid email format");
		}
	}
	
	/*
	 * Validates Indian Phone numbers.
	 * 
	 * Rule:
	 *  - Must start with 6,7,8,9
	 *  - Must be exactly 10 digits
	 */
	public static void validatePhone(String phone) throws ValidationException {
		if (!Pattern.matches("^[6-9][0-9]{9}$", phone)) {
			throw new ValidationException("Invalid Phone number format");
		}
	}

	/*
	 * Validates Employee ID format
	 * Rule:
	 * 	- Must follow EMP-XXXX where X is a digit
	 */
	public static void validateEmployeeId(String employeeId) throws ValidationException {
		if (!Pattern.matches("^EMP-\\d{4}$", employeeId)) {
			throw new ValidationException("Invalid Employee ID format");
		}
	}
}