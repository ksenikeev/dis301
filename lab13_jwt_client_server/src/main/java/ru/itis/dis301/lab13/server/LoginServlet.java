package ru.itis.dis301.lab13.server;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    final static Logger logger = LogManager.getLogger(LoginServlet.class);

    private Properties properties;

    public void init() {
        try {
            properties = new Properties();
            properties.load(LoginServlet.class.getClassLoader().getResourceAsStream("application.properties"));
            logger.debug(properties.get("secret"));
        } catch (IOException e) {
            logger.error(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //TODO проверка данных пользователя
        if (properties.get("username").equals(username)
                && properties.get("password").equals(password)) {
            // Формируем и отправляем токен
            String token = JWT.create()
                    .withSubject("username")
                    .withClaim("roles", "admin")
                    .sign(Algorithm.HMAC256((String)properties.get("secret")));

            logger.debug(token);
            response.getOutputStream().write(token.getBytes());
            response.flushBuffer();
        } else {
            logger.debug("Bad username or password");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Bad username or password");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
