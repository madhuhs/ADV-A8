package com.jspiders.pms.services;


import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.erros.DuplicateUserException;
import com.jspiders.pms.erros.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    public String createUser(AddUserReq addUserReq){
        //System.out.println("this is createUser of UserService");
        logger.info("UserSerivce.createUser : {}",addUserReq);
        //logic to add user
        //assume user already exists
        //throw exception
        /*IllegalArgumentException illegalArgumentException =
                new IllegalArgumentException("User already exists : "+addUserReq.getEmail());*/

        DuplicateUserException duplicateUserException =
                new DuplicateUserException("User already exists : "+addUserReq.getEmail());
        logger.error("DuplicateUserException : ",duplicateUserException);
        throw duplicateUserException;


    }
}
