package ru.itis.dis301.lab2_01;

import ru.itis.dis301.lab2_01.annotation.Component;
import ru.itis.dis301.lab2_01.annotation.Inject;
import ru.itis.dis301.lab2_01.model.Abonent;
import ru.itis.dis301.lab2_01.service.PhoneBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Application {

    private List<Abonent> abonents;

    @Inject
    private PhoneBookService service;

    public Application() {
        abonents = new ArrayList<>();
        // Формируем справочник телефонов
    }

    public void run() {
        //
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер телефона для поиска абонента:");
            String number = scanner.nextLine();

            if (number.equals("exit")) {
                break;
            }

            // обращаемся к сервисному классу для получения абонента по номеру
        }

    }

}
