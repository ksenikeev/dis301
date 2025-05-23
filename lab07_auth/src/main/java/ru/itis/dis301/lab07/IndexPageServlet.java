package ru.itis.dis301.lab07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/index")
public class IndexPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            String username = (String)request.getSession(false)
                    .getAttribute("user");

            System.out.println(username);

            request.setAttribute("username", username);

            request.getRequestDispatcher("index.ftl").forward(request, response);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }

}
