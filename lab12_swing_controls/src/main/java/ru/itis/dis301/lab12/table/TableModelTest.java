package ru.itis.dis301.lab12.table;

import javax.swing.*;
import java.awt.*;

public class TableModelTest extends JFrame {

    public TableModelTest() {
        super("TableModelTest");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTable table1 = new JTable(new MonthTableModel());

        setLayout(new GridLayout(3, 1));
        add(new JScrollPane(table1));

        setSize(350, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new TableModelTest(); } });
    }
}
