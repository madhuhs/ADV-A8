package com.jspiders.pms.controllers;

import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.services.UserServiceV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceV2 userServicev2;
    @Autowired//constructor injection
    public AdminController(UserServiceV2 userService2){
        this.userServicev2 = userService2;
    }
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/user/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        logger.info("UserControllerV2 -> getAllUsers()");
        return userServicev2.getAllUsers();
    }
}
