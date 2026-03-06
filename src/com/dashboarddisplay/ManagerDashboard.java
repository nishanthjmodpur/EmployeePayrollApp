package com.dashboarddisplay;


import java.util.*;

import com.employeepayroll.Payslip;
import com.employeeregistration.Employee;

/*
 * Manager Dashboard:
 * This class implements the Dashboard interface and overrides the display method
 * to print manager specific information.
 */

public class ManagerDashboard implements Dashboard {
    @Override
    public void display(ArrayList<Payslip> payslips, Employee employee) {
        System.out.println("\n=== MANAGER DASHBOARD ===");
        System.out.println("Manager: " + employee.getName());
        System.out.println("Dashboard Type: " + this.getClass().getName());

        double total = payslips.stream().mapToDouble(Payslip::getNetpay).sum();
        System.out.println("\nTeam Total YTD Earnings: " + total);
    }
}