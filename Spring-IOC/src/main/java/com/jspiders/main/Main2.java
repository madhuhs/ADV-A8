package com.jspiders.main;

import com.jspiders.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Employee e1 = (Employee) context.getBean("employee");

        System.out.println(e1.toString());
    }
}
