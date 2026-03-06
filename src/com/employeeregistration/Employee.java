package com.employeeregistration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class represents Employee entity
 */

public class Employee {
	private static int counter = 1;
	private String empId;
	private String name;
	private String email;
	private String phone;
	
	private UserAccount account;
	
	public Employee(String name, String email, String phone, UserAccount userAccount) {
		this.empId = generateEmpId();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.account = account;
	}
	
	/*
	 * generates a new empId of format EMP-XXXX, where X is a number, with the 
	 * help of the static counter variable.
	 */
	public String generateEmpId() {
		return String.format("EMP-%04d", counter++);
	}
	
	/*
	 * Override toString method to make it display employee details in a readable format.
	 */
	
	@Override
	public String toString() {
		return "Employee ID : " + empId + "\n" +
				"Name        : " + name + "\n" +
				"Email       : " + email + "\n" +
				"Phone       : " + phone + "\n" +
				"Username    : " + account.getLoginId();
	}
	
	public String getEmpId() {
		return empId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}

	
	/*
	 * Saves employee data into a file
	 * 
	 * Purpose:
	 * 	- Simulates persistence
	 */
	
	public void persist() throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter((empId + ".txt")))) {
			writer.write(String.join(" ",	"empId:", empId, "name:", name, "email:", email, "phone:", phone));
		} catch (IOException e) {
			System.err.println("An error occurred while writing to a file: " + e.getMessage());
		}
	}
}