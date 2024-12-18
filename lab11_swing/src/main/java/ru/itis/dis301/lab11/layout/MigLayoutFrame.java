package ru.itis.dis301.lab11.layout;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Используем менеджер расположения MigLayout - элементы располагаются на основании описания
 *  Команды:
 *  gap [size] - после компоненты необходимо вставить пусто пространство размером size
 *  wrap - после компоненты перейти на новую строку
 *  sg [имя] - компонента будет принадлежать группе с указанным именем (будет выровнено по самому большому компоненту)
 *  span [n] - компонент займет n ячеек
 *  skip [n] - пропустить n ячеек перед компонентой
 *  grow[x|y] [вес] - при наличии свободного места компонента будет расти по X и/или Y
 */
public class MigLayoutFrame extends JFrame {

    private JTextField tfUserName;
    private JTextField tfPassword;

    private JButton btnLogin;
    private JButton btnCansel;

    public MigLayoutFrame() {
        super("MigLayoutFrame");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new MigLayoutFrame(); } });
    }

}
