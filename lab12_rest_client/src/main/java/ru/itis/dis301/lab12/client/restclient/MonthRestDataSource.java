package ru.itis.dis301.lab12.client.restclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dis301.lab12.model.Month;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class MonthRestDataSource implements IMonthDataSource {

    public List<Month> findAll() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/lab12rest/month/list"))
                .GET()
                .build();

        HttpResponse response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        String respBody = (String) response.body();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(respBody, new TypeReference<List<Month>>() {});
    }

    public Month findById(Long id) {
        // TODO send get to http://localhost:8080/lab12rest/month/{id}
        return null;
    }

    public Month save(Month month) {
        // TODO send post to http://localhost:8080/lab12rest/month/save
        return null;
    }

    public void delete(Long id) {
        // TODO send post to http://localhost:8080/lab12rest/month/delete/{id}
    }
}
