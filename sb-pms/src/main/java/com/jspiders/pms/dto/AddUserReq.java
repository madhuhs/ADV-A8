package com.jspiders.pms.dto;

import jakarta.validation.constraints.NotNull;

public class AddUserReq {
    @NotNull(message = "name cannot null or empty")
    private String name;
    private String email;
    private String role;

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AddUserReq{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
