package ru.itis.dis301.lab11.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**

 */
public class MainFrame extends JFrame {

    private JPanel panelS;
    private JPanel panelN;
    private JPanel panelC;
    private JPanel panelW;
    private JPanel panelE;

    public MainFrame() {
        super("Главное окно");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 1000);

        this.setLayout(new BorderLayout());

        panelN = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelC = new JPanel(new MigLayout());
        panelE = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelW = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelS = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panelN.add(new Label("Заголовок главного окна!"));
        panelW.add(new JButton("LP"));
        panelE.add(new JButton("RP"));

        JTextField tfUserName;
        JTextField tfPassword;

        JButton btnLogin;
        JButton btnCansel;

        tfUserName = new JTextField(20);
        tfPassword = new JTextField(20);

        btnLogin = new JButton("Войти");
        btnCansel = new JButton("Отмена");

        panelC.add(new Label("Имя пользователя"), "gap, sg 1");
        panelC.add(tfUserName, "wrap");
        panelC.add(new Label("Пароль"), "gap, sg 1");
        panelC.add(tfPassword, "wrap");
        panelC.add(btnLogin, "gap");
        panelC.add(btnCansel, "wrap");




        panelS.add(new Label("(C) ИТИС"));

        this.add(panelN, BorderLayout.NORTH);
        this.add(panelS, BorderLayout.SOUTH);
        this.add(panelC, BorderLayout.CENTER);
        this.add(panelE, BorderLayout.EAST);
        this.add(panelW, BorderLayout.WEST );

        //this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new MainFrame(); } });
    }

}
