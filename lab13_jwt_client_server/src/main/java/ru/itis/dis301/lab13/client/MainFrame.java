package ru.itis.dis301.lab13.client;

import javax.swing.*;

public class MainFrame extends JFrame {

    private ClientContext context;

    public MainFrame(ClientContext context) {
        super("Времена года");
        this.context = context;
    }
}
