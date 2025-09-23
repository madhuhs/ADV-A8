package com.jspiders.pms.controllers;

import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.dto.AddUserResponse;
import com.jspiders.pms.dto.UserResponseDto;
import com.jspiders.pms.services.UserService;
import com.jspiders.pms.services.UserServiceV2;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable int id) {
        logger.info("UserControllerV2 -> getUser() id : {}",id);
        return userServicev2.getUserById(id);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
        logger.info("UserControllerV2 -> getAllUsers()");
        return userServicev2.getAllUsers();
    }
    //Assignment
    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable String email) {
        logger.info("UserControllerV2 -> getUserByEmail() email : {}",email);
        return null;
    }

    @GetMapping("/all/{role}")
    public ResponseEntity<List<UserEntity>> getAllUsersByRole(@PathVariable String role){
        logger.info("UserControllerV2 -> getAllUsersByRole()");
        return null;
    }


    @GetMapping("/all/{name}")
    public ResponseEntity<List<UserEntity>> getAllUsersByName(@PathVariable String name){
        logger.info("UserControllerV2 -> getAllUsersByName()");
        return null;
    }
}
