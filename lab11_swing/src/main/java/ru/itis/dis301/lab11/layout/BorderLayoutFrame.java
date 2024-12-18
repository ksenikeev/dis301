package ru.itis.dis301.lab11.layout;

import javax.swing.*;
import java.awt.*;

/**
 * Используем менеджер расположения BorderLayout - элементы располагаются по границам и в центре
 * компоненты располагаем с указанием места BorderLayout.NORTH (SOUTH, WEST, EAST, CENTER)
 *
 * Этот менеджер удобно использовать для главного окна
 */
public class BorderLayoutFrame extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    public BorderLayoutFrame() {
        super("Пример работы с 2 кнопками");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 1000);

        this.setLayout(new BorderLayout());

        button1 = new JButton("Кнопка 1");
        button2 = new JButton("Кнопка 2");
        button3 = new JButton("Кнопка 3");
        button4 = new JButton("Кнопка 4");
        button5 = new JButton("Кнопка 5");

        this.add(button1, BorderLayout.NORTH);
        this.add(button2, BorderLayout.SOUTH);
        this.add(button3, BorderLayout.CENTER);
        this.add(button4, BorderLayout.EAST);
        this.add(button5, BorderLayout.WEST );

        //this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new BorderLayoutFrame(); } });
    }

}
