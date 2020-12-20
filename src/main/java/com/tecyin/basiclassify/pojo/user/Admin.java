package com.tecyin.basiclassify.pojo.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
