package ru.itis.dis301.lab12.list;

import ru.itis.dis301.lab12.model.Month;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * Используем собственную модель элемента списка
 * можно реализовать ListModel или наследовать от AbstractListModel
 */

public class CustomListModelTest extends JFrame {
    // наша модель
    private MonthElementListModel monthListModel;

    public CustomListModelTest() {

        super("MonthElementListModel");

        setLayout(new FlowLayout());
        setSize(400, 200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        List<Month> monthList = Arrays.asList(new Month[]{
                new Month("Январь", "Зима"),
                new Month("Февраль","Зима"),
                new Month("Март","Весна"),
                new Month("Апрель","Весна"),
                new Month("Май","Весна"),
                new Month("Июнь","Лето"),
                new Month("Июль","Лето"),
                new Month("Август","Лето"),
                new Month("Сентябрь","Осень"),
                new Month("Октябрь","Осень"),
                new Month("Ноябрь","Осень"),
                new Month("Декабрь","Зима")
        });

        // заполним модель данными
        monthListModel = new MonthElementListModel(monthList);


        JList list1 = new JList(monthListModel);


        JButton btnshowMonth = new JButton("Ваш выбор");

        btnshowMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        ((Month)list1.getSelectedValue()).getFullInfo(), "Ваш выбор", 1, null);
            }
        });

        // добавляем компоненты
        add(btnshowMonth);
        add(new JScrollPane(list1));
        setVisible(true);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new CustomListModelTest(); } });
    }
}