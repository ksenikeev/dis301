package ru.itis.dis301.lab07.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ru.itis.dis301.lab07.db.DbWork;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebListener
public class Lab07ContexListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        DbWork.getInstance();

        Map<UUID, Long> userSessions = new HashMap<>();

        event.getServletContext().setAttribute("USER_SESSIONS", userSessions);
    }

    public void contextDestroyed(ServletContextEvent event) {
        DbWork.getInstance().destroy();
        Map userSessions = (Map) event.getServletContext().getAttribute("USER_SESSIONS");
        userSessions.clear();
    }
}
