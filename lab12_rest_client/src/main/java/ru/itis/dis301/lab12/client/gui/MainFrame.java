package ru.itis.dis301.lab12.client.gui;

import ru.itis.dis301.lab12.client.service.MonthService;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MonthService service = new MonthService();

    public MainFrame() {
        super("12 месяцев");

        setLayout(new FlowLayout());
        setSize(400, 400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Получаем список всех месяцев через сервис, и создаем модель данных для списка
        ListModel monthListModel = null;
        try {
            monthListModel = new MonthElementListModel(service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            monthListModel = new DefaultListModel();
            ((DefaultListModel)monthListModel).add(0, "Не удалось загрузить данные");
        }

        JList listMonth = new JList(monthListModel);

        add(new JScrollPane(listMonth));
        setVisible(true);
    }

}
