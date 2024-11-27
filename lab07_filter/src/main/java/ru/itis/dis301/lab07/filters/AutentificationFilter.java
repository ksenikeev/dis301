package ru.itis.dis301.lab07.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter("/*")
public class AutentificationFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (httpServletRequest.getServletPath().startsWith("/static/") ||
                httpServletRequest.getServletPath().startsWith("/usercheck")) {

            filterChain.doFilter(request, response);
        } else {
            if (httpServletRequest.getCookies() != null) {
                Optional<Cookie> cookie =
                        Arrays.stream(httpServletRequest.getCookies())
                                .filter(c -> {
                                    return c.getName().equals("SECRET_KEY") && c.getValue().equals("password");
                                }).findFirst();
                if (cookie.isPresent()) {
                    filterChain.doFilter(request, response);
                } else {
                    request.getRequestDispatcher("/login").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/login").forward(request, response);
            }
        }
    }
}
