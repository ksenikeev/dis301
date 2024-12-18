package ru.itis.dis301.lab11.layout;

import javax.swing.*;
import java.awt.*;

/**
 * Используем менеджер расположения FlowLayout - элементы располагаются слева-направо, сверху-вниз
 * с учетом предпочтительного размера компоненты, если она указана
 */
public class FlowLayoutFrame extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel label1;
    private JLabel label2;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public FlowLayoutFrame() {
        super("Пример работы с 2 кнопками");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 1000);

        // В конструкторе можно задать направление выравнивания, FlowLayout.RIGHT ...
        this.setLayout(new FlowLayout());

        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100, 30));
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(20);
        textField6 = new JTextField(20);

        button1 = new JButton("Кнопка 1");
        button2 = new JButton("Кнопка 2");
        button3 = new JButton("Кнопка 3");
        button4 = new JButton("Кнопка 4");

        label1 = new JLabel("Метка 1");
        label2 = new JLabel("Метка 2");

        this.add(label1);
        this.add(textField1);

        this.add(label2);
        this.add(textField2);

        this.add(textField3);
        this.add(textField4);
        this.add(textField5);
        this.add(textField6);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);

        this.revalidate();
        //this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new FlowLayoutFrame(); } });
    }

}
