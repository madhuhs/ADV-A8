package com.jspiders.jdbc;

import java.sql.*;

public class Mainclass {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/companydb";
        String user = "root";
        String password = "root";

        try {
           Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL");

            String insertStmt = "insert into companydb.emp values(0,'Emp1','Dev',2000,10)";

            Statement statement = connection.createStatement();

            //statement.execute(insertStmt);

            String updateStmt = "update companydb.emp set ename = 'Employee' where empid = 1";

            //statement.execute(updateStmt);

            String deleteStmt = "delete from companydb.emp where empid = 10";

            statement.execute(deleteStmt);

            connection.close();
            System.out.println("Disconnect from Mysql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
