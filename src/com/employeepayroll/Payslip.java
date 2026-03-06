package com.employeepayroll;

import com.employeeregistration.Employee;

//============== Payslip ================
/*
* Payslip represents a monthly salary statement.
*
* It combines:
* - Employee details (aggregation)
* - Salary details (composition)
*
* Payslip acts as a READ-ONLY view once created.
*/

public class Payslip {
	private Employee employee;           
	private SalaryComponents components; 
	private String month;

	public Payslip(Employee employee, SalaryComponents components, String month) {
		this.employee = employee;
		this.components = components;
		this.month = month;
	}

	@Override
	public String toString() {
		return "\n=========== PAYSLIP ============\n"
				+ "Month           : " + month + "\n"
				+ "Employee ID     : " + employee.getEmpId() + "\n"
				+ "Employee Name   : " + employee.getName() + "\n\n"
				+ "---- Earnings ----\n"
				+ "Basic Salary    : " + components.basicSalary + "\n"
				+ "HRA             : " + components.hra + "\n"
				+ "DA              : " + components.da + "\n"
				+ "Allowances      : " + components.allowances + "\n\n"
				+ "---- Deductions ----\n"
				+ "PF              : " + components.pf + "\n"
				+ "Tax             : " + components.tax + "\n\n"
				+ "Net Pay         : " + components.netPay + "\n"
				+ "===============================\n";
	}
	
	public String getEmployeeId() {
		return employee.getEmpId();
	}
	
	public String getEmpName() {
		return employee.getName();
	}
	
	public String getMonth() {
		return month;
	}
	
	public double getNetpay() {
		return components.netPay;
	}
}