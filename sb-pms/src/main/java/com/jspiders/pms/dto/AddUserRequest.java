package com.jspiders.pms.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddUserRequest {
    @NotBlank(message = "name cannot be empty")
    private String name;
    private String email;
    private String role;
}
