package com.example.entities;


import lombok.Data;

import javax.persistence.*;

@Table(name = "users")
@Entity()
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long userId;

    private String username;

    private String password;

    private String role;

    private short enabled;
}