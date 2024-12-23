package ru.itis.dis301.lab12.client;

import ru.itis.dis301.lab12.client.gui.MainFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new MainFrame(); } });
    }
}
