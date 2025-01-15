package ru.itis.dis301.lab13.client;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new ClientContext(); }
                });
    }
}
