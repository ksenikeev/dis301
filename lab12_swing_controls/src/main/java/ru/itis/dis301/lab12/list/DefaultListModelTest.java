package ru.itis.dis301.lab12.list;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DefaultListModelTest extends JFrame {
    // наша модель
    private DefaultListModel dlm;

    public DefaultListModelTest() {

        super("DefaultListModelTest");

        setLayout(new FlowLayout());
        setSize(400, 200);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // заполним модель данными
        dlm = new DefaultListModel();

        dlm.add(0, "Январь");
        dlm.add(0, "Февраль");
        dlm.add(0, "Март");

        JList list1 = new JList(dlm);

        JButton btnAddMonth = new JButton("Добавить");

        btnAddMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String month = JOptionPane.showInputDialog("Укажите новый месяц");

                dlm.add(0, month);
            }
        });

        JButton btnshowMonth = new JButton("Ваш выбор");
        btnshowMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, (String)list1.getSelectedValue(), "Ваш выбор", 1, null);
            }
        });

        // добавляем компоненты
        add(btnAddMonth);
        add(btnshowMonth);

        add(new JScrollPane(list1));

        setVisible(true);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new DefaultListModelTest(); } });
    }
}