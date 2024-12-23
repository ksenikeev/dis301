package ru.itis.dis301.lab12.client.restclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.dis301.lab12.model.Month;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IMonthDataSource {

    List<Month> findAll() throws URISyntaxException, IOException, InterruptedException;

    Month findById(Long id);

    Month save(Month month);

    void delete(Long id);
}
