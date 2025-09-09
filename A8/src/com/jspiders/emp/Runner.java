package com.jspiders.emp;

import com.jspiders.emp.db.EmployeeDb;
import com.jspiders.emp.db.EmployeeDbImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

interface EmpDb{
    void addEmployee(String name,String job,int salary,int deptNo);

    void deleteEmployee(int empId);
}

class EmpDbImpl implements EmployeeDb{
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/companydb";
    private final String user = "root";
    private final String password = "root";
    private Connection connection;
    @Override
    public void addEmployee(String name, String job, int salary, int deptNo) {
        init();
        try {
            Statement statement = connection.createStatement();
            String insertStmt = "insert into companydb.emp values(0,'Emp1','Dev',2000,10)";
            statement.execute(insertStmt);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Employee data added to DB");
    }
    @Override
    public void deleteEmployee(int empId) {
    }

    private void init(){
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcUrl, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Runner {

    public static void main(String[] args) {
        EmpDbImpl employeeDb = new EmpDbImpl();
        employeeDb.addEmployee("aaa","bb",0,10);
    }
}
