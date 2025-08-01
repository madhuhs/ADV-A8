package com.jspiders.emp.db;

public class EmployeeDbImpl implements EmployeeDb{
    @Override
    public void addEmployee(String name, String job, int salary, int deptNo) {
        System.out.println("Employee data added to DB");
    }

    @Override
    public void deleteEmployee(int empId) {
        System.out.println("Employee data deleted from DB");
    }
}
