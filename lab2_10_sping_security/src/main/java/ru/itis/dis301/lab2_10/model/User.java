package ru.itis.dis301.lab2_10.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Builder
public class User {
    private Long id;
    private String userName;
    private String password;
    private String role;
}
