# HttpClient

```java
HttpClient httpClient = HttpClient.newBuilder()
    .version(HttpClient.Version.HTTP_1_1)
    .connectTimeout(Duration.ofSeconds(10))
    .build();

HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("https://httpbin.org/get"))
        .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
        .build();

HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

// print response headers
HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

```

```java
    HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(URI.create("https://httpbin.org/get"))
        .setHeader("User-Agent", "Java 11 HttpClient Bot")
        .build();

    CompletableFuture<HttpResponse<String>> response =
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    
    String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        System.out.println(result);
```

```java
    HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    Map<Object, Object> data = new HashMap<>();
        data.put("username", "abc");
        data.put("password", "123");
        data.put("custom", "secret");
        data.put("ts", System.currentTimeMillis());

    HttpRequest request = HttpRequest.newBuilder()
        .POST(ofFormData(data))
        .uri(URI.create("https://httpbin.org/post"))
        .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
        .header("Content-Type", "application/x-www-form-urlencoded")
        .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        System.out.println(response.body());

```


HttpRequest.BodyPublishers.ofString("String body")

HttpRequest.BodyPublishers
    .ofInputStream(() -> new FileInputStream("test.txt"))

HttpRequest.BodyPublishers.ofByteArray({1,2,3})

HttpRequest.BodyPublishers.fromFile(
    Paths.get("src/test/resources/sample.txt"))

## Response
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandler.asString());

BodyHandlers.ofByteArray
BodyHandlers.ofString
BodyHandlers.ofFile
BodyHandlers.discarding
BodyHandlers.replacing
BodyHandlers.ofLines
BodyHandlers.fromLineSubscriber