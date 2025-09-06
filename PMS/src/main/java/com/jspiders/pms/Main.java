package com.jspiders.pms;

import com.jspiders.pms.data.dto.SignupRequest;
import com.jspiders.pms.service.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class Main {
    UserService userService;
    public static void main(String[] args) {
        System.out.println("Program starts...");

        SignupRequest request = new SignupRequest();

        request.setName("abcd");
        request.setEmail("user@gmail.com");
        request.setPhone("987643210");
        request.setAge(23);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<SignupRequest>> errors =
                validator.validate(request);

        if(!errors.isEmpty()){
            for(ConstraintViolation<SignupRequest> error : errors) {
                System.out.println(error.getMessage()
                        + " Invalid input : "+error.getInvalidValue());
            }

            throw new IllegalArgumentException("Invalid data in input");
        }


        System.out.println("Program ends..");
    }
}

