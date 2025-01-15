package ru.itis.dis301.lab14.ball;


import javax.swing.*;
import java.awt.*;

public class GraphDemo extends JFrame {

    public GraphDemo() {
        super("game");

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //createBufferStrategy(2);
        setLayout(new BorderLayout());

        add(new GComponent());
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() { new GraphDemo(); }
                });
    }

}
