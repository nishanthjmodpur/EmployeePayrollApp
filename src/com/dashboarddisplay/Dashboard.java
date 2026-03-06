package com.dashboarddisplay;


import java.util.ArrayList;

import com.employeepayroll.Payslip;
import com.employeeregistration.Employee;

/*
 * This interface declares a method display to be implemented by Employee and Manager Dashboard.
 */

public interface Dashboard {
    void display(ArrayList<Payslip> payslips, Employee employee);
}