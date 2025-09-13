package com.jspiders.pms.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUser(){
        return "this is get user";
    }

    @PostMapping
    public String createUser(){
        return "this is create user";
    }

    @PutMapping
    public String updateUser(){
        return "this is update user";
    }

    @DeleteMapping
    public String deleteUser(){
        return "this is delete user";
    }
}
