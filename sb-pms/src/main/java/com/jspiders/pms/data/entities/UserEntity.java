package com.jspiders.pms.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    private int id;
    private String name;
    private String email;
    private String role;
    private LocalDate createdAt;
}