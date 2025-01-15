package ru.itis.dis301.lab13.server;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

@WebFilter("/*")
public class AutentificationFilter implements Filter {

    final static Logger logger = LogManager.getLogger(AutentificationFilter.class);

    private Properties properties;

    @Override
    public void init(FilterConfig filterConfig) {
        try {
            properties = new Properties();
            properties.load(LoginServlet.class.getClassLoader().getResourceAsStream("application.properties"));
            logger.debug(properties.get("secret"));
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (httpServletRequest.getServletPath().startsWith("/login")) {
            logger.debug("pass /login");
            filterChain.doFilter(request, response);
        } else {
            String authHeader = ((HttpServletRequest) request).getHeader("Authorization");
            logger.debug(authHeader);
            if (authHeader != null) {
                String token = authHeader.substring(7);

                try {
                    DecodedJWT decodedJWT =
                            JWT.require(Algorithm.HMAC256((String)properties.get("secret")))
                            .build()
                            .verify(token);

                    request.setAttribute("user", decodedJWT.getSubject());
                    logger.debug("username = " + decodedJWT.getSubject());

                } catch (JWTVerificationException e) {
                    logger.debug(e);
                    ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
                }

                filterChain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }
}
