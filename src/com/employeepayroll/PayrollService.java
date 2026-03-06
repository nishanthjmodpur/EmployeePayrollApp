package com.employeepayroll;

import com.employeeregistration.Employee;

//============== Payroll Service ================
/*
* PayrollService encapsulates salary calculation logic.
*
* Purpose:
* - Separates business rules from main() for clarity
* - Ensures calculations are reusable, testable, and isolated
* - Supports extension (bonuses, deductions, tax rules) without breaking existing code
*
* Design Note:
* This is a SERVICE class, following the Single Responsibility Principle.
*/

public class PayrollService {
	/*
	 * Generates a payslip by:
	 * - Creating salary components
	 * - Applying calculation rules
	 * - Returning a completed Payslip object
	 */

	public Payslip generatePayslip(Employee employee, String month,
			double basic, double hra, double da, double allowances) {

		SalaryComponents sc = new SalaryComponents(basic, hra, da, allowances);

		// ---- Gross Salary Calculation ----
		double gross = basic + hra + da + allowances;

		// ---- Deductions ----
		sc.pf = basic * 0.12;        // Provident Fund (12%)
		sc.tax = gross * 0.10;       // Income Tax (10%) - demo rule

		// ---- Net Pay ----
		sc.netPay = gross - (sc.pf + sc.tax);

		return new Payslip(employee, sc, month);
	}
}
