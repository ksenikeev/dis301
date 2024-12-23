package ru.itis.dis301.lab12.table;

import javax.swing.*;
import java.awt.*;

public class SimpleTableTest extends JFrame {
    // данные для таблиц
    private Object[][] months = new String[][] {
            { "Январь", "Зима" },
            { "Февраль", "Зима" },
            {"Март", "Весна"}
    };
    // названия заголовков столбцов
    private Object[] colorsHeader = new String[] {
            "Месяц", "Сезон"
    };
    public SimpleTableTest() {
        super("SimpleTableTest");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable table1 = new JTable(months, colorsHeader);


        table1.setRowHeight(40);
        table1.setIntercellSpacing(new Dimension(10, 10));
        table1.setGridColor(Color.green);
        //table1.setShowVerticalLines(false);

        table1.setForeground(Color.red);
        table1.setSelectionForeground(Color.yellow);
        table1.setSelectionBackground(Color.blue);
        //table1.setShowGrid(false);


        setLayout(new GridLayout(3, 1));
        add(new JScrollPane(table1));

        setSize(350, 400);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new SimpleTableTest(); } });
    }
}
