package ru.itis.dis301.lab13;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTVerificator {
    public static void main(String[] args) {
        String SECRET = "123efeas134";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjk2NzYzIiwicm9sZXMiOiJzdXBlcmFkbWluIiwibmFtZSI6IlVzZXIxIiwiZW1haWwiOiJ1c2VyQHBvc3QucnUifQ.IscQhhArYoN6Jgi7Ii59D82Ry2gSco_TMtx885flyos";
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);

            System.out.println(decodedJWT.getClaim("name"));
            System.out.println(decodedJWT.getClaim("email"));
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
    }
}
