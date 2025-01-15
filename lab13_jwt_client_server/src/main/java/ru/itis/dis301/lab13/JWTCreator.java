package ru.itis.dis301.lab13;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTCreator {
    public static void main(String[] args) {
        String SECRET = "123efeas134";
        String token = JWT.create()
                .withSubject("1296763")
                .withClaim("name", "User1")
                .withClaim("roles", "admin")
                .withClaim("email", "user@post.ru")
                .sign(Algorithm.HMAC256(SECRET));

        System.out.println(token);
    }
}
