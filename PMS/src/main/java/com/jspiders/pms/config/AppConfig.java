package com.jspiders.pms.config;

import com.jspiders.pms.data.UserRespository;
import com.jspiders.pms.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.jspiders.pms")
@EnableAspectJAutoProxy
public class AppConfig {
}
