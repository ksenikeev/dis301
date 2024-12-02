package ru.itis.dis301.lab07.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.itis.utils.Utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter("/*")
public class AutentificationFilter implements Filter {

    final static Logger logger = LogManager.getLogger(AutentificationFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        logger.info("Аутентифицируем " + request.getRemoteAddr() + ":" + request.getRemotePort()
                + " " + Utils.upper(httpServletRequest.getServletPath()));

        if (httpServletRequest.getServletPath().startsWith("/static/") ||
                httpServletRequest.getServletPath().startsWith("/usercheck") ||
                httpServletRequest.getServletPath().startsWith("/login")) {

            logger.debug("Запрос статического ресурса " + request.getRemoteAddr() + ":" + request.getRemotePort()
                    + " " + httpServletRequest.getServletPath());

            filterChain.doFilter(request, response);
        } else {
            // Проверяем аутентификацию
            // Если нет ассоциированной с пользователем сессии мы ее не создаем
            HttpSession session = httpServletRequest.getSession(false);
            if (session != null) {
                filterChain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/login").forward(request, response);
            }
        }
    }
}
