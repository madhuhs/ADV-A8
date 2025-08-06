package com.jspiders.sms.services;
import com.jspiders.sms.dto.StudentDTO;

public class StudentDTOValidator {
    public static void validateStudentDTO(StudentDTO studentDTO){
       checkName(studentDTO);
       checkDeptNo(studentDTO);
    }
    private static void checkName(StudentDTO studentDTO){
      String name =  studentDTO.getName();
      if (name == null || name.length() < 4){
          throw  new IllegalArgumentException("Name should be minimum 4 chars : "+name);
      }
    }

    private static void checkDeptNo(StudentDTO studentDTO){
        int deptNo = studentDTO.getDept();
        if(deptNo <=0 ){
            throw  new IllegalArgumentException("Invalid Dept No : "+deptNo);
        }
    }
}