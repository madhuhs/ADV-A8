package com.jspiders.pms.controllers;

import com.jspiders.pms.dto.AddUserRequest;
import com.jspiders.pms.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    @PostMapping
    public String addUser(@RequestBody @Valid AddUserRequest
                                      addUserRequest){
        System.out.println(addUserRequest);
       //userService.createUser();
        return "this is create user";
    }

}
