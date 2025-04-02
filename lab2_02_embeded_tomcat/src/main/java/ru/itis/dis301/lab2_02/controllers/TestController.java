package ru.itis.dis301.lab2_02.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis301.lab2_02.annotations.Controller;
import ru.itis.dis301.lab2_02.annotations.GetRequest;
import ru.itis.dis301.lab2_02.model.Model;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TestController {

    @GetRequest("/test")
    public Model getTestPage(HttpServletRequest request, HttpServletResponse response) {
        // ...
        Model model = new Model("test");
        model.add("param1", "value1");
        model.add("param2", "value2");

        //Возвращаем имя представления
        return model;
    }

    @GetRequest("/home")
    public Model getHomePage(HttpServletRequest request, HttpServletResponse response) {
        return new Model("home");
    }

}
