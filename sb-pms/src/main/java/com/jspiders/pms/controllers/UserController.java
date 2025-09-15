package com.jspiders.pms.controllers;

import com.jspiders.pms.dto.AddUserRequest;
import com.jspiders.pms.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid AddUserRequest
                                      addUserRequest){
        System.out.println(addUserRequest);
       //userService.createUser();
        return ResponseEntity.ok("this is create user");
    }

}
