package ru.itis.dis301.lab2_04.orm;

import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.Closeable;
import java.sql.SQLException;

public class EntityManagerFactory implements Closeable {

    final static Logger logger = LogManager.getLogger(EntityManagerFactory.class);

    private DataSource dataSource;

    public EntityManagerFactory() {
        try {
            Class.forName("org.postgresql.Driver");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/music");
            config.setUsername("postgres");
            config.setPassword("postgres");
            config.setConnectionTimeout(50000);
            config.setMaximumPoolSize(10);
            dataSource = new HikariDataSource(config);

            logger.info("data source created");
        } catch (ClassNotFoundException e) {
            logger.error("", e);
            e.printStackTrace();
        }
    }

    public void close() {
        ((HikariDataSource) dataSource).close();
    }

    public EntityManager createEntityManager() throws SQLException {
        return new EntityManagerImpl(dataSource.getConnection());
    }


}
