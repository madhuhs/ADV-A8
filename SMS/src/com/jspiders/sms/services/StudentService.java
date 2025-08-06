package com.jspiders.sms.services;

import com.jspiders.sms.dto.StudentDTO;

import java.sql.SQLException;

public interface StudentService {
    void addStudent(StudentDTO studentDTO) throws SQLException;
}

