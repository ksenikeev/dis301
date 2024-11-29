package ru.itis.dis301.lab07.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter("/*")
public class AutentificationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (httpServletRequest.getServletPath().startsWith("/static/") ||
                httpServletRequest.getServletPath().startsWith("/usercheck") ||
                httpServletRequest.getServletPath().startsWith("/login")) {

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
