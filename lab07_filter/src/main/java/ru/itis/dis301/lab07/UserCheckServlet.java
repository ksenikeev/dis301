package ru.itis.dis301.lab07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usercheck")
public class UserCheckServlet extends HttpServlet {

    private static String SECRET_KEY = "password";
    private static String SECRET_KEY_NAME = "secret_key";

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{

            String key_value = request.getParameter(SECRET_KEY_NAME);
            if (SECRET_KEY.equals(key_value)) {
                response.addCookie(new Cookie("SECRET_KEY", "password"));
                request.getRequestDispatcher("index.ftl").forward(request, response);
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
