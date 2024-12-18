package ru.itis.dis301.lab11.testframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс - обработчик сообщения от органа управления
 */
public class ButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();

            if (btn.getText().equals("Кнопка 1")) {
                System.out.println("pressed btn 1");

                MessageWindow messageWindow = new MessageWindow();
                messageWindow.setMessage("Hello!");
                messageWindow.setVisible(true);

            } else {
                System.out.println("pressed btn 2");
                ImageIcon icon = new ImageIcon("favico.png");
                JOptionPane.showMessageDialog(
                        null,
                        "Форма ввод данных", "справочная",
                        JOptionPane.INFORMATION_MESSAGE, icon);
            }

        } else {
            System.out.println("иной орган управления");
        }
    }
}
