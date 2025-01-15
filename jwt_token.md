# JWT

https://jwt.io/

1. Стандарт  RFC 7519
2. Применяется в системах аутентификации без сохранения состояния
3. Структурно состоит из 3-х частей
   - Header
   - Payload
   - Signature
4. Header - описывает тип токена и алгоритмы хеширования
   ```json
   {
       "alg": "HS256",
       "typ": "JWT"
   }
   ```
5. Payload - содержательная часть (claims), состоящее из претензий отправителя на определенные права
   ```json
   {
      "sub": "192344",
      "name": "User1",
      "roles": "ADMIN"
   }
   ```
7. Signature - хеш от заголовка + содержимого и секретной фразы (
   ```
   HMACSHA256(
   base64UrlEncode(header) + "." +
   base64UrlEncode(payload),
   secret))
   ```
7. Итоговое представление токена (X.Y.Z): Base64(Header).Base64(Payload).Base64(Signature)
8. Типовое использование токена предполагает размещение в HTTP заголовке
   ```
   Authorization: Bearer <token>
   ```
9. JSON Web Token Claims (https://www.iana.org/assignments/jwt/jwt.xhtml)
   - iss - Issuer
   - sub - Subject
   - exp - Expiration Time
   - name - Full name
   - jti - JWT ID
   - client_id - Client Identifier
   - roles - Roles
10. Работа с JWT в Java
   ```xml
     <dependency>
         <groupId>com.auth0</groupId>
         <artifactId>java-jwt</artifactId>
         <version>3.15.0</version>
     </dependency>
   ```
11. Создание токена
   ```java
        String SECRET = "123efeas134";
        String token = JWT.create()
                .withSubject("1296763")
                .withClaim("name", "User1")
                .withClaim("roles", "admin")
                .withClaim("email", "user@post.ru")
                .sign(Algorithm.HMAC256(SECRET));
   ```
12. Проверка токена
   ```java
        String SECRET = "123efeas134";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMCIsInJvbGUiOiJVU0VSIiwic3RhdGUiOiJBQ1RJVkUiLCJlbWFpbCI6ImtzZW5pa2VldkBrcGZ1LnJ1In0.xHn_3KWs3rLGF8rxAfZusLBdZ_PuKbW4ehB6dQOAD9g";
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);

            System.out.println(decodedJWT.getClaim("name"));
            System.out.println(decodedJWT.getClaim("email"));
        } catch (JWTVerificationException e) {
            // ...
        }
   ```

## Использование JWT
1. Клиент авторизуется на сервере (например, через отправку данных формы логина)
2. Сервер формирует токен и отправляет клиенту
3. Клиент отправляет запросы на сервер, включая в заголовок токен