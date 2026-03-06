package com.dashboarddisplay;


import java.util.ArrayList;

import com.employeepayroll.Payslip;
import com.employeeregistration.Employee;


public interface Dashboard {
    void display(ArrayList<Payslip> payslips, Employee employee);
}