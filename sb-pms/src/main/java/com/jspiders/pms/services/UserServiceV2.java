package com.jspiders.pms.services;

import com.jspiders.pms.controllers.UserControllerV2;
import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.data.repositories.UserRepository;
import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.dto.AddUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceV2 {
    private final Logger logger = LoggerFactory.getLogger(UserControllerV2.class);

    @Value("${app.constants.success}")
    private String addUserSuccessMsg;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceV2(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ResponseEntity<AddUserResponse> addUser(AddUserReq addUserReq){
        logger.info("UserServiceV2 - addUser() {} ",addUserReq);
        //logic to add to user to db
        //Map -- DTO -- ENTITY
        logger.info("Mapping userDTO --> UserENTITY");
        UserEntity userEntity = new UserEntity();
        String name = addUserReq.getName();
        userEntity.setName(name);
        userEntity.setRole(addUserReq.getRole());
        userEntity.setEmail(addUserReq.getEmail());
        userEntity.setCreatedAt(LocalDate.now());
        userEntity.setUserId(0);

        //save user-entity to database
        logger.info("Trying to save data to db");
        userRepository.save(userEntity);
        logger.info(addUserSuccessMsg);
        AddUserResponse addUserResponse = new AddUserResponse();
        addUserResponse.setName(addUserReq.getName());
        addUserResponse.setSuccess(true);
        addUserResponse.setMessage(addUserSuccessMsg);
        return ResponseEntity.ok(addUserResponse);
    }
}
