package ru.itis.dis301.lab2_10.controller;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.dis301.lab2_10.security.UserDetailImpl;

@Controller
public class SimpleAuthController {

    @GetMapping("/simpleauth")
    public String index(Model model) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        Authentication authentication =
                new TestingAuthenticationToken("user", "user", "USER");
        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);
        model.addAttribute("user", "test");
        return "index";
    }
}
