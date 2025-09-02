package com.jspiders.main;

import com.jspiders.AppConfig;
import com.jspiders.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main3 {
    public static void main(String[] args) {
     ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

    Employee e1 = context.getBean(Employee.class);
        System.out.println(e1.toString());

    }
}
