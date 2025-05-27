package ru.itis.dis301.lab2_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SprinSecurityLoginForm {
    public static void main(String[] args) {



        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("user"));



        SpringApplication.run(SprinSecurityLoginForm.class, args);
    }
}
