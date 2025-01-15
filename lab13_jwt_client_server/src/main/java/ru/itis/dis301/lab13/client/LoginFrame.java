package ru.itis.dis301.lab13.client;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField tfUserName;
    private JTextField tfPassword;

    private JButton btnLogin;
    private JButton btnCansel;

    private ClientContext context;

    public LoginFrame(ClientContext context) {
        super("Вход во времена года");

        this.context = context;

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //setSize(600, 300);

        setLayout(new MigLayout());

        tfUserName = new JTextField(20);
        tfPassword = new JTextField(20);

        btnLogin = new JButton("Войти");
        btnCansel = new JButton("Отмена");

        add(new Label("Имя пользователя"), "gap, sg 1");
        add(tfUserName, "wrap");
        add(new Label("Пароль"), "gap, sg 1");
        add(tfPassword, "wrap");
        add(btnLogin, "gap");
        add(btnCansel, "wrap");

        pack();
        // Управление видимостью из вне
        //this.setVisible(true);
    }
}
