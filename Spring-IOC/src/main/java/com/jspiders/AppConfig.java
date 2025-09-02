package com.jspiders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jspiders")
public class AppConfig {
    @Bean
    public Employee employee(){
        Employee e1 = new Employee();
        e1.setName("Emp1");
        e1.setId(1);
        return e1;
    }
}
