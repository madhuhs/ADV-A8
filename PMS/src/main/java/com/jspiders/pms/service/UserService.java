package com.jspiders.pms.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void addUser(){
        System.out.println("Adding user");
    }
    public void UpdateUser(){
        System.out.println("Update user");
        int res = 20 / 0;
    }

    public void deleteUser(){
        System.out.println("Delete user");
    }

}
