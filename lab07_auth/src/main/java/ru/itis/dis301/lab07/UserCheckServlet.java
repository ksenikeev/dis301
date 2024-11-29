package ru.itis.dis301.lab07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@WebServlet("/usercheck")
public class UserCheckServlet extends HttpServlet {

    private static String USER_NAME = "user";
    private static String PASSWORD = "password";

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            if (USER_NAME.equals(userName) &&
                            PASSWORD.equals(password)) {
                // JSESSIONID
                // Клиент получит действующую куку
                HttpSession session = request.getSession();
                // Сохраним в сессии пользователя его имя
                session.setAttribute("user", "Kamil");
                // отправляем на главную страницу,
                // будет еще одна проверка в фильтре, которую
                // пользователь должен пройти автоматом
                response.sendRedirect("index.ftl");
            } else {
                request.getRequestDispatcher("login.ftl").forward(request, response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }

}
