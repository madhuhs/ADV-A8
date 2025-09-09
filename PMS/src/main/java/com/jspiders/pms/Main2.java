package com.jspiders.pms;

import com.jspiders.pms.config.AppConfig;
import com.jspiders.pms.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Program starts...");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService service = context.getBean(UserService.class);
        service.UpdateUser();

        System.out.println("Program ends...");
    }
}
