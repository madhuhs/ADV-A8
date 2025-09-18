package com.jspiders.pms.services;


import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.erros.DuplicateUserException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String createUser(AddUserReq addUserReq){
        System.out.println("this is createUser of UserService");
        //logic to add user
        //assume user already exists
        //throw exception
        /*IllegalArgumentException illegalArgumentException =
                new IllegalArgumentException("User already exists : "+addUserReq.getEmail());*/

        DuplicateUserException duplicateUserException =
                new DuplicateUserException("User already exists : "+addUserReq.getEmail());

        throw duplicateUserException;
    }
}
