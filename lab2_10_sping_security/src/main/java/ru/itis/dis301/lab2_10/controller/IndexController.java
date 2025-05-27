package ru.itis.dis301.lab2_10.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.dis301.lab2_10.security.UserDetailImpl;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        UserDetailImpl userDetails =
                (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", userDetails.getUsername());
        return "index";
    }
}
