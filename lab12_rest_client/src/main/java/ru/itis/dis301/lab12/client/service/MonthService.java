package ru.itis.dis301.lab12.client.service;

import ru.itis.dis301.lab12.client.restclient.IMonthDataSource;
import ru.itis.dis301.lab12.client.restclient.MonthRestDataSource;
import ru.itis.dis301.lab12.model.Month;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class MonthService {

    private IMonthDataSource dataSource = new MonthRestDataSource();

    public List<Month> findAll() throws URISyntaxException, IOException, InterruptedException {
        return dataSource.findAll();
    }

    public Month findById(Long id) {
        return dataSource.findById(id);
    }

    public Month save(Month month) {
        return dataSource.save(month);
    }

    public void delete(Long id) {
        dataSource.delete(id);
    }
}
