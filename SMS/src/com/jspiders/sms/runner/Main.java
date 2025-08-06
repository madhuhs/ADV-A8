package com.jspiders.sms.runner;

import com.jspiders.sms.db.StudentDB;
import com.jspiders.sms.dto.StudentDTO;
import com.jspiders.sms.entities.StudentEntity;
import com.jspiders.sms.services.StudentDTOValidator;
import com.jspiders.sms.services.StudentService;
import com.jspiders.sms.services.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starts...");
         testGetAll();
       // testAdd();
        System.out.println("Program ends...");
    }

    private static void testAdd() {
        System.out.println("Enter student data");
        Scanner input = new Scanner(System.in);

        StudentDTO studentDTO = new StudentDTO();

        System.out.println("Enter student's name");
        studentDTO.setName(input.next());

        System.out.println("Enter student's dept");
        studentDTO.setDept(input.nextInt());

        System.out.println("Enter student's DOB");
        studentDTO.setDob(input.next());

        System.out.println("Enter student's skills");
        studentDTO.setSkills(input.next());

        try {
//           // StudentDTOValidator.validateStudentDTO(studentDTO);
//            StudentService studentService = new StudentServiceImpl();
//            studentService.addStudent(studentDTO);

            StudentDB studentDB  = new StudentDB();
            studentDB.delete(10);
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.err.println("Error : "+ex.getMessage());
        }
    }
    public  static  void testGetAll(){
        StudentDB studentDB = new StudentDB();
        try {
            List<StudentEntity> studentList = studentDB.getAll();
            studentList.forEach((studentEntity -> {
                System.out.println(studentEntity);
            }));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}