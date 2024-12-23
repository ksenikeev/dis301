package ru.itis.dis301.lab12.client.restclient;

import ru.itis.dis301.lab12.model.Month;

import java.util.Arrays;
import java.util.List;

public class MonthTestDataSource implements IMonthDataSource {

    private List<Month> testData = Arrays.asList(new Month[]{
            new Month(1L, "Январь", "Зима"),
            new Month(2L, "Февраль","Зима"),
            new Month(3L, "Март","Весна"),
            new Month(4L, "Апрель","Весна"),
            new Month(5l, "Май","Весна"),
            new Month(6l, "Июнь","Лето"),
            new Month(7l, "Июль","Лето"),
            new Month(8l, "Август","Лето"),
            new Month(9l, "Сентябрь","Осень"),
            new Month(10l, "Октябрь","Осень"),
            new Month(11l, "Ноябрь","Осень"),
            new Month(12l, "Декабрь","Зима")
    });

    public List<Month> findAll() {
        return testData;
    }

    public Month findById(Long id) {
        return null;
    }

    public Month save(Month month) {
        return null;
    }

    public void delete(Long id) {

    }
}
