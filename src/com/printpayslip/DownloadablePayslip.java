package com.printpayslip;

/*
 * 
 * Payslip represents a finalized salary record.
 * 
 * Key idea introduced here:
 * 	- Immutability
 * 
 * Once a payslip is generated:
 * 	- Its data should never change
 * 	- Any operation (print/download) must use a copy
 * 
 * Making the class final prevents inheritance-based modification.
 */

public final class DownloadablePayslip implements Cloneable {
	private final String empId;
	private final String empName;
	private final String month;
	private final double netPay;

	public DownloadablePayslip(String empId, String empName, String month, double netPay) {
		this.empId = empId;
		this.empName = empName;
		this.month = month;
		this.netPay = netPay;
	}

	public String getEmpId() { return empId; }
	public String getEmpName() { return empName; }
	public String getMonth() { return month; }
	public double getNetPay() { return netPay; }

	/*
	 * Creates a safe copy of the payslip
	 * 
	 * Why cloning is needed:
	 * 	- Original object should remain untouched
	 * 	- Downloaded or printed version must be independent
	 */
	@Override
	public Object clone() {
		return new DownloadablePayslip(empId, empName, month, netPay);
	}
	
	/*
	 * Defines logical equality between two payslips.
	 * 
	 * Two payslips are considered equal if:
	 * 	- They belong to the same employee
	 * 	- They are for the same month
	 */

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof DownloadablePayslip)) return false;
		DownloadablePayslip other = (DownloadablePayslip) o;
		return empId.equals(other.empId) && month.equals(other.month);
	}
	
	/*
	 * hashCode() is implemented to be consistent with equals().
	 * 
	 * This is important when objects are used in collections.
	 */

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + empId.hashCode();
		result = 31 * result + month.hashCode();
		return result;
	}
	
	/*
	 * Converts payslip data into readable text
	 * 
	 * Used for:
	 * 	- Console printing
	 * 	- File download
	 */

	@Override
	public String toString() {
		return "PAYSLIP\n"
				+ "Employee ID   : " + empId + "\n"
				+ "Employee Name : " + empName + "\n"
				+ "Month         : " + month + "\n"
				+ "Net Pay       : " + netPay + "\n";
	}
}