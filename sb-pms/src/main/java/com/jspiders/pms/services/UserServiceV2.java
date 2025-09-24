package com.jspiders.pms.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jspiders.pms.controllers.UserControllerV2;
import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.data.repositories.UserRepository;
import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.dto.AddUserResponse;
import com.jspiders.pms.dto.UpdateUserReq;
import com.jspiders.pms.dto.UserResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceV2 {
    private final Logger logger = LoggerFactory.getLogger(UserControllerV2.class);

    @Value("${app.constants.success}")
    private String addUserSuccessMsg;

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceV2(UserRepository userRepository,
                         ObjectMapper objectMapper){
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
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

    public ResponseEntity<String> updateEmail(String oldEmail, String newEmail) {
        logger.info("UserService - updateEmail()");

        //verify if user exists with given oldEmail
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(oldEmail);
        UserEntity userEntity = userEntityOptional.orElseThrow();

        userEntity.setEmail(newEmail);//update the email with new email
        userRepository.save(userEntity);//save the data to db
        return ResponseEntity.ok("User data updated");
    }

    @Transactional
    public ResponseEntity<String> updateUser(UpdateUserReq updateUserReq) {
        logger.info("UserService - updateUser()");
        //verify if user exists by ID
       boolean userExists = userRepository.existsById(updateUserReq.getId());

       if(userExists) {
           UserEntity userEntity = objectMapper.convertValue(updateUserReq, UserEntity.class);
           userEntity.setUserId(updateUserReq.getId());
           userEntity.setCreatedAt(LocalDate.now());
           logger.info("user {}",userEntity);
           userRepository.save(userEntity);
       }
       else{
           throw new NoSuchElementException("user with the given ID : "
                   +updateUserReq.getId()+" does not exist");
       }

        return ResponseEntity.ok("Use data updated");
    }

    @Transactional
    public ResponseEntity<String> deleteUser(int userId) {
       // userRepository.deleteById(userId);//hard delete

      //soft delete
      UserEntity userEntity =  userRepository.findById(userId).orElseThrow();
      userEntity.setActive(false);
      userRepository.save(userEntity);
      return ResponseEntity.ok("User deleted");
    }


}
