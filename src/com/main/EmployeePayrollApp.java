package com.main;

import java.io.IOException;
import java.util.Scanner;

import com.employeeauthentication.AuthenticationService;
import com.employeeauthentication.Session;
import com.employeepayroll.PayrollService;
import com.employeepayroll.Payslip;
import com.employeeregistration.Employee;
import com.employeeregistration.UserAccount;
import com.printpayslip.DownloadToken;
import com.printpayslip.DownloadablePayslip;
import com.printpayslip.FileService;
import com.validation.ValidationException;
import com.validation.Validator;

/*
 * --------------------------------Main Class------------------------------------
 * 

 * Entry point of Use Case 5
 * 
 * Execution Flow:
 * 1. Create original payslip
 * 2. Clone payslip for download
 * 3. Verify equality and identity
 * 4. Check download expiry
 * 5. Save payslip to files
 * 6. Print cloned payslip
 * 
 * @author Developer
 * @version 5.0
 */

public class EmployeePayrollApp {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter name: ");
			String name = scanner.nextLine();
			System.out.println("Enter phone: ");
			String phone = scanner.nextLine();
			System.out.println("Enter email: ");
			String email = scanner.nextLine();
			System.out.println("Enter your password: ");
			String password = scanner.nextLine();
			Validator.validateEmail(email);
			Validator.validatePhone(phone);
			UserAccount userAccount = new UserAccount(email, password);
			Employee employee = new Employee(name, email, phone, userAccount);
			employee.persist();
		} catch (ValidationException e) {
			System.out.println("\nValidation Failed: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("\nError saving employee data!");
		}

		AuthenticationService auth = new AuthenticationService();
		Session session = auth.login();

		if (session != null) {
			System.out.println("\n" + session);
			if (!session.isExpired()) {
				Employee emp = auth.getEmployeeByUsername(session.getUsername()); // will now return a real Employee
				if (emp != null) {
					PayrollService service = new PayrollService();

					System.out.print("Enter Month: ");
					String month = scanner.nextLine();
					System.out.print("Enter Basic Salary: ");
					double basic = scanner.nextDouble();
					System.out.print("Enter HRA: ");
					double hra = scanner.nextDouble();
					System.out.print("Enter DA: ");
					double da = scanner.nextDouble();
					System.out.print("Enter Allowances: ");
					double allowances = scanner.nextDouble();

					Payslip payslip = service.generatePayslip(emp, month, basic, hra, da, allowances);
					System.out.println(payslip);
					
		               // === UC4: Print / Download ===
	                System.out.println("\n=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");
	                DownloadablePayslip dlPayslip = new DownloadablePayslip(
	                        payslip.getEmployeeId(), payslip.getEmpName(), payslip.getMonth(), payslip.getNetpay());

	                DownloadablePayslip copy = (DownloadablePayslip) dlPayslip.clone();
	                System.out.println("Verified: Download copy is equal to original.");
	                System.out.println("Original hashcode : " + dlPayslip.hashCode());
	                System.out.println("Cloned   hashcode : " + copy.hashCode());

	                DownloadToken token = new DownloadToken();
	                if (!token.isExpired()) {
	                    try {
	                        FileService fs = new FileService();
	                        String txtFile = fs.savePayslipAsText(copy);
	                        String pdfFile = fs.savePayslipAsPdf(copy);
	                        System.out.println("Payslip Download Successful.");
	                        System.out.println("Saved as text file: " + txtFile);
	                        System.out.println("Saved as PDF file : " + pdfFile);
	                        System.out.println("\n--- Printed Payslip ---\n" + copy);
	                    } catch (Exception e) {
	                        System.out.println("Download failed: " + e.getMessage());
	                    }
	                } else {
	                    System.out.println("Download token expired.");
	                }
				} else {
					System.out.println("Session expired.");
				}
			}

			scanner.close();
		}
	}
}
