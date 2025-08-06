package com.jspiders.sms.services;

import com.jspiders.sms.db.StudentDB;
import com.jspiders.sms.dto.StudentDTO;
import com.jspiders.sms.entities.StudentEntity;

import java.sql.SQLException;

public class StudentServiceImpl implements  StudentService{
    @Override
    public void addStudent(StudentDTO studentDTO) throws SQLException {
        StudentDTOValidator.validateStudentDTO(studentDTO);

        StudentDB studentDB = new StudentDB();
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName(studentDTO.getName());
        studentEntity.setDept(studentDTO.getDept());
        studentEntity.setDob(studentDTO.getDob());
        studentEntity.setSkills(studentDTO.getSkills());
        studentEntity.setSid(0);
        studentEntity.setActive(true);

        studentDB.save(studentEntity);

        System.out.println("Student registered");
    }

}