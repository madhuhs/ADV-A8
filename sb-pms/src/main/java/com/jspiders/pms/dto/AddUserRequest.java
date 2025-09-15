package com.jspiders.pms.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddUserRequest {
    @NotNull(message = "name cannot be empty")
    private String name;
    private String email;
    private String role;
}
