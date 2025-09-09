package com.jspiders.main;

import com.jspiders.AppConfig;
import com.jspiders.Demo;
import com.jspiders.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main4 {
    @Autowired
    Employee emp;

    public static void main(String[] args) {
        System.out.println("Program starts...");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Main4 m1 = new Main4();
        m1.test();
        System.out.println("Program ends...");
    }

    public void test(){
        System.out.println("this is test()");
        System.out.println(emp);
    }
}
