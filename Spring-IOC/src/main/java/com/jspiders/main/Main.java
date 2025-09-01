package com.jspiders.main;

import com.jspiders.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program starts,...");

      ApplicationContext context =
              new ClassPathXmlApplicationContext("ApplicationContext.xml");

      Demo d2 = (Demo) context.getBean("demo");
      d2.test();


        System.out.println("Program ends...");
    }
}