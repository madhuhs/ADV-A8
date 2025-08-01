package com.jspiders.emp.db;

import java.sql.SQLException;

public interface EmployeeDb {
    void addEmployee(String name,String job,int salary,int deptNo) throws SQLException;

    void deleteEmployee(int empId);
}
