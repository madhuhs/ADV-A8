package com.jspiders.sms.services;

import com.jspiders.sms.dto.StudentDTO;

public class StudentServiceImpl implements  StudentService{
    @Override
    public void addStudent(StudentDTO studentDTO) {
        System.out.println(studentDTO.getName());

        System.out.println("Student added to db");

    }
}