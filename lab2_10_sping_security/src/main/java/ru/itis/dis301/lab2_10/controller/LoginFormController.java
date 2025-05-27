package ru.itis.dis301.lab2_10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

}
