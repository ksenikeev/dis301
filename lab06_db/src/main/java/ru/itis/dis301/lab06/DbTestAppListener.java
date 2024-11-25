package ru.itis.dis301.lab06;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class DbTestAppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // Создаем подключение
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Закрываем подключение
    }
}
