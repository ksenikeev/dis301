package ru.itis.dis301.lab05;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet("*.thtml")
public class TemplateHandlerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            Writer writer = response.getWriter();

            writer.write("<!doctype html>");
            writer.write("<html lang=\"en\">");
            writer.write("<head>");
            writer.write("<meta charset=\"UTF-8\">");
            writer.write("<title>ExtendedServlet</title>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<h1>HttpServletExample</h1>");
            writer.write("</body>");
            writer.write("</html>");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
