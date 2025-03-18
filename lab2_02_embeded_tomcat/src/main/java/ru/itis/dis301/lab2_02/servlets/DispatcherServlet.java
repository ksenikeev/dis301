package ru.itis.dis301.lab2_02.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis301.lab2_02.controllers.TestController;

import java.io.IOException;

@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) {

        String path = request.getPathInfo();

        TestController controller = new TestController();

        try {
            switch (path) {
                case "/test":
                    controller.getTestPage(request, response);
                    break;
                case "/home":
                    controller.getHomePage(request, response);
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
