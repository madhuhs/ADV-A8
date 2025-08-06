package com.jspiders.sms.db;

import com.jspiders.sms.entities.StudentEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    private String dbUrl = "";
    private String user = "";
    private String password = "";
    private Connection connection;

    public StudentDB(){
        try {
            connection = DriverManager.getConnection(dbUrl,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(StudentEntity studentEntity) throws SQLException {
       PreparedStatement preparedStatement =
               connection.prepareStatement("insert into tablename values (0,?,?,?,?)");
        preparedStatement.setString(1,studentEntity.getName());
        preparedStatement.setInt(2,studentEntity.getDept());

        preparedStatement.execute();
        System.out.println("Student data added to DB");
    }

    public void delete(int id) throws SQLException {
     PreparedStatement preparedStatement =
             connection.prepareStatement("delete from tablename where sid = ?");

     preparedStatement.setInt(1,id);
     preparedStatement.execute();
    }

    public void update(StudentEntity studentEntity) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("");
        preparedStatement.setString(1,studentEntity.getName());
        preparedStatement.setInt(2,studentEntity.getDept());
        preparedStatement.executeUpdate();
    }

    public List<StudentEntity> getAll() throws SQLException {
        String select = "Select * from tablename";
       Statement statement = connection.createStatement();
       ResultSet resultSet =  statement.executeQuery(select);

       //mapping
//        StudentEntity studentEntity = new StudentEntity();
//        resultSet.next();
//        int sid = resultSet.getInt("sid");
//        studentEntity.setSid(sid);
//        String name = resultSet.getString("sname");
//        studentEntity.setName(name);
//        studentEntity.setDept(resultSet.getInt("deptno"));
//
//        StudentEntity studentEntity2 = new StudentEntity();
//        resultSet.next();

        List<StudentEntity> studentsList = new ArrayList<>();
        while (resultSet.next()){
            StudentEntity studentEntity = new StudentEntity();
            int sid = resultSet.getInt("sid");
            studentEntity.setSid(sid);
            String name = resultSet.getString("sname");
            studentEntity.setName(name);
            studentEntity.setDept(resultSet.getInt("deptno"));
            studentsList.add(studentEntity);
        }
       return studentsList;
    }
}








