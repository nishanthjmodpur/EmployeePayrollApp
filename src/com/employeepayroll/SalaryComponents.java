package com.employeepayroll;


//============== Salary Components (Composition) ================
/*
* SalaryComponents groups all salary-related values.
*
* Why this class exists:
* - Salary details belong together
* - Keeps Payslip clean and readable
*
* This introduces COMPOSITION:
* - Payslip owns SalaryComponents
* - SalaryComponents has no meaning without Payslip
*/

public class SalaryComponents {
		double basicSalary;
		double hra;
		double da;
		double allowances;
		double pf;
		double tax;
		double netPay;

		public SalaryComponents(double basicSalary, double hra, double da, double allowances) {
			this.basicSalary = basicSalary;
			this.hra = hra;
			this.da = da;
			this.allowances = allowances;
		}
}
