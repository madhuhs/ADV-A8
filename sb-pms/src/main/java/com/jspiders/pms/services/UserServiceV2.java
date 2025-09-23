package com.jspiders.pms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jspiders.pms.controllers.UserControllerV2;
import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.data.repositories.UserRepository;
import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.dto.AddUserResponse;
import com.jspiders.pms.dto.UserResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
//        UserEntity userEntity = new UserEntity();
//        String name = addUserReq.getName();
//        userEntity.setName(name);
//        userEntity.setRole(addUserReq.getRole());
//        userEntity.setEmail(addUserReq.getEmail());
//        userEntity.setCreatedAt(LocalDate.now());
//        userEntity.setUserId(0);

        ObjectMapper objectMapper = new ObjectMapper();
        UserEntity userEntity = objectMapper.convertValue(addUserReq,UserEntity.class);

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

    public ResponseEntity<UserResponseDto> getUserById(int id){
        logger.info("UserService - getUserById() id : {}",id);
        UserEntity userEntity =  userRepository.findById(id).get();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());//register Java-8 time
        objectMapper.configure
                (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        UserResponseDto userResponseDto =
                objectMapper.convertValue(userEntity, UserResponseDto.class);
        logger.info("Name : {}",userEntity.getName());
        return ResponseEntity.ok(userResponseDto);
    }

//    public ResponseEntity<String> getAllUsers() {
//        logger.info("UserService - getAllUsers()");
//       List<UserEntity> userEntityList =(List<UserEntity>) userRepository.findAll();
//       logger.info("Number of users {}",userEntityList.size());
//       return ResponseEntity.ok("number of users : "+userEntityList.size());
//    }
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        logger.info("UserService - getAllUsers()");
        List<UserEntity> userEntityList =(List<UserEntity>)
                userRepository.findAll();
        return ResponseEntity.ok(userEntityList);
    }
}
