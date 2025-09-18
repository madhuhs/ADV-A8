package com.jspiders.pms.controllers;

import com.jspiders.pms.dto.AddUserReq;
import com.jspiders.pms.dto.AddUserResponse;
import com.jspiders.pms.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private final UserService userService;
    @Autowired//constructor injection
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody AddUserReq addUserRequest){
        System.out.println("name : "+addUserRequest.getName());
        System.out.println("email : "+addUserRequest.getEmail());
        System.out.println("role : "+addUserRequest.getRole());
       return  ResponseEntity.status(HttpStatus.CREATED).body("user created");
    }

    //DO NOT write any logic in controllers
    @PostMapping("/v2")
    public ResponseEntity<AddUserResponse> addUserv2
    (@RequestBody @Valid AddUserReq addUserRequest){
//        AddUserResponse response = new AddUserResponse();
//        response.setMessage("user created");
//        response.setSuccess(true);
//        String name = addUserRequest.getName();
//        response.setName(name);

        //userService.createUser(addUserRequest);

        return  ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getUser(@PathVariable String name){
        System.out.println(name.toLowerCase());
        return  ResponseEntity.ok("hello "+name);
    }

    @GetMapping("/{name}/{email}")
    public ResponseEntity<String> getUserByNameAndEmail(@PathVariable String name,
                                          @PathVariable String email){
        return  ResponseEntity.ok("hello "+name +" your email is : "+email);
    }

    @GetMapping
    public ResponseEntity<String> getUserByEmailAndRole(@RequestParam String email,
                                                        @RequestParam String role){
        return  ResponseEntity.ok("hello "+email +" your role is : "+role);
    }


}
