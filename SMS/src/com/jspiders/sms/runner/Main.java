package com.jspiders.sms.runner;

import com.jspiders.sms.dto.StudentDTO;
import com.jspiders.sms.services.StudentDTOValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starts...");

        System.out.println("Enter student data");
        Scanner input = new Scanner(System.in);

        StudentDTO studentDTO = new StudentDTO();

        System.out.println("Enter student's name");
        studentDTO.setName(input.next());

        System.out.println("Enter student's dept");
        studentDTO.setDept(input.nextInt());
//
//        System.out.println("Enter student's DOB");
//        studentDTO.setDob(input.next());
//
//        System.out.println("Enter student's skills");
//        studentDTO.setSkills(input.next());

        try {
            StudentDTOValidator.validateStudentDTO(studentDTO);
        }
        catch (IllegalArgumentException ex){
            System.err.println("Error : "+ex.getMessage());
        }


        System.out.println("Program ends...");
    }
}