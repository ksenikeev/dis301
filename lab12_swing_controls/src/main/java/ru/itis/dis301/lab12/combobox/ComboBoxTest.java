package ru.itis.dis301.lab12.combobox;

import ru.itis.dis301.lab12.model.Month;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ComboBoxTest extends JFrame {
    // массив с элементами списка
    public String[] elements = new String[] {
            "Январь", "Февраль", "Март", "Апрель"
    };

    public ComboBoxTest() {
        super("ComboBoxTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JComboBox combo1 = new JComboBox(elements);
        combo1.setEditable(true);

        combo1.setPrototypeDisplayValue("Длинный элемент");

        // второй раскрывающийся список
        Vector<Month> monthList = new Vector<>( Arrays.asList(new Month[]{
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
        }));

        JComboBox combo2 = new JComboBox(monthList);
        combo2.setMaximumRowCount(6);

        JButton btnshowMonth = new JButton("Ваш выбор");
        btnshowMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        combo1.getSelectedItem(), "Ваш выбор", 1, null);
            }
        });



        setLayout(new FlowLayout());
        add(combo1);
        add(combo2);
        add(btnshowMonth);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new ComboBoxTest(); } });
    }
}
