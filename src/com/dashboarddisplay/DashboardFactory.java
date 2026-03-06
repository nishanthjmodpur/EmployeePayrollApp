package com.dashboarddisplay;

/*
 * Dashboard Factory:
 * This class is responsible for inject objects dynamically at runtime
 */

public class DashboardFactory {
    public static Dashboard getDashboard(String role) {
        if ("EMPLOYEE".equalsIgnoreCase(role)) {
            return new EmployeeDashboard();
        } else if ("MANAGER".equalsIgnoreCase(role)) {
            return new ManagerDashboard();
        }
        return null;
    }
}