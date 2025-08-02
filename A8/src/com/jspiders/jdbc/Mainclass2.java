package com.jspiders.jdbc;

import java.sql.*;

public class Mainclass2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/companydb";
        String user = "root";
        String password = "root";

        try {
           Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL");

            String insertStmt = "insert into companydb.emp values(0,?,?,?,?)";
            String updateStmt = "update companydb.emp set ename = 'Employee' where empid = 1";
            String deleteStmt = "delete from companydb.emp where empid = 10";

//            PreparedStatement preparedStatement = connection.prepareStatement(insertStmt);
//            preparedStatement.setString(1,"NewEmp1");
//            preparedStatement.setString(2,"Test");
//            preparedStatement.setInt(3,2000);
//            preparedStatement.setInt(4,10);
//
//            preparedStatement.execute();
//

            PreparedStatement preparedStatement =
                    connection.prepareStatement("Select * from companydb.emp");

            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            int empid = resultSet.getInt("empid");
//            System.out.println(empid);
//            String ename = resultSet.getString("ename");
//            System.out.println(ename);
//
//            resultSet.next();
//            empid = resultSet.getInt("empid");
//            System.out.println(empid);
//            ename = resultSet.getString("ename");
//            System.out.println(ename);

            while (resultSet.next()){
               int empid = resultSet.getInt("empid");
              String  ename = resultSet.getString("ename");
                System.out.println(empid + " "+ ename);
            }

            connection.close();
            System.out.println("Disconnect from Mysql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



