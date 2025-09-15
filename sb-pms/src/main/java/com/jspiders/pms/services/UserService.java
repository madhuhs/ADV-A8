package com.jspiders.pms.services;

import com.jspiders.pms.data.entities.UserEntity;
import com.jspiders.pms.data.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {
    public String createUser(){
        UserEntity userEntity = new UserEntity();
       return "user created";
    }
}
