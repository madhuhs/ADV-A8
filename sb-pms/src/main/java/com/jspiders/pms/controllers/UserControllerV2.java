package com.jspiders.pms.controllers;

import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.dto.AddUserResponse;
import com.jspiders.pms.services.UserService;
import com.jspiders.pms.services.UserServiceV2;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/users")
//@RequiredArgsConstructor//constructor injection
public class UserControllerV2 {

    @Value("${app.constants.success}")
    private String addUserSuccessMsg;
    private final UserServiceV2 userServicev2;
    @Autowired//constructor injection
    public UserControllerV2(UserServiceV2 userService2){
        this.userServicev2 = userService2;
    }
    private final Logger logger = LoggerFactory.getLogger(UserControllerV2.class);

    @PostMapping
    public ResponseEntity<AddUserResponse> createUser
            (@RequestBody AddUserReq addUserReq)
    {
        logger.info("Add user req received : {}",addUserReq);
        logger.info(addUserSuccessMsg);
        return userServicev2.addUser(addUserReq);
    }
}
