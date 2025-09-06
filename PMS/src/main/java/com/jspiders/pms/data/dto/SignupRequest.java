package com.jspiders.pms.data.dto;


import com.jspiders.pms.validators.ValidEmail;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class SignupRequest {
    //@NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be null")
    @Length(min = 4,max = 40,message = "Name should be min 4 chars max 40 chars")
    private String name;
    @Email(message = "Invalid email id")
    @ValidEmail
    //@gmail , @yahoo , @outlook
    private String email;
    @Length(min = 10,max = 10, message = "Invalid Phone number")
    private String phone;
    @Min(value = 18, message = "Age should be greater than 18")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
