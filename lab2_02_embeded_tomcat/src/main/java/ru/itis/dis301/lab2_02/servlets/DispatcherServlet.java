package ru.itis.dis301.lab2_02.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis301.lab2_02.controllers.TestController;
import ru.itis.dis301.lab2_02.model.Model;
import ru.itis.dis301.lab2_02.model.View;
import ru.itis.dis301.lab2_02.model.ViewResolver;

import java.io.IOException;

@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String path = request.getPathInfo();
        String httpMethod = request.getMethod().toUpperCase();

        TestController controller = new TestController();


        Model model = switch (path) {
                case "/test" ->
                    controller.getTestPage(request, response);
                case "/home" ->
                    controller.getHomePage(request, response);
                default -> null;
            };
        View view = new ViewResolver(model).resolve();
        view.render(response);

    }

}
