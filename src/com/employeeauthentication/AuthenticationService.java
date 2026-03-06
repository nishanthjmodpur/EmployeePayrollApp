package com.employeeauthentication;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Authentication Service
public class AuthenticationService {
	private Map<String, User> users = new HashMap<>();
	private int maxAttempts = 3;

	public AuthenticationService() {
		loadUsersFromFile("employee_data.txt");
	}

	// Load registered employees from file
	private void loadUsersFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				// Format: empId,name,email,phone,username,password
				String[] parts = line.split(",");
				if (parts.length >= 6) {
					String username = parts[4];
					String password = parts[5];
					// For demo: treat EMP-0001 as Manager, others as Employee
					if (parts[0].startsWith("EMP-0001")) {
						users.put(username, new Manager(username, password));
					} else {
						users.put(username, new RegularEmployee(username, password));
					}
				}
			}
		} catch (IOException e) {
			System.out.println("No registered users found. Please run UC1 first.");
		}
	}

	public Session login() {
		Scanner sc = new Scanner(System.in);
		int attempts = 0;

		while (attempts < maxAttempts) {
			System.out.print("Enter Username: ");
			String username = sc.nextLine();

			System.out.print("Enter Password: ");
			String password = sc.nextLine();

			User user = users.get(username);
			if (user != null && user.authenticate(username, password)) {
				System.out.println("\nLogin Successful!");
				System.out.println("Role: " + user.getRole());
				showDashboard(user.getRole());
				return new Session(username);
			} else {
				attempts++;
				System.out.println("Login Failed! Attempts left: " + (maxAttempts - attempts));
			}
		}
		System.out.println("Maximum login attempts exceeded. Access denied.");
		return null;
	}

	private void showDashboard(String role) {
		System.out.println("\n======= DASHBOARD =======");
		if ("EMPLOYEE".equals(role)) {
			System.out.println("Employee Dashboard");
			System.out.println("View Payslip | Update Profile");
		} else if ("MANAGER".equals(role)) {
			System.out.println("Manager Dashboard");
			System.out.println("View Team | Approve Requests");
		}
	}
	
}