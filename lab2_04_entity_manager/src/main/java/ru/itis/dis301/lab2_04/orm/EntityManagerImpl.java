package ru.itis.dis301.lab2_04.orm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EntityManagerImpl implements EntityManager {

    private Connection connection;

    public EntityManagerImpl(Connection connection) {
        this.connection = connection;
    }

    public void close() throws SQLException {
        connection.close();
    }

    @Override
    public <T> T save(T entity) {
        return null;
    }

    @Override
    public void remove(Object entity) {

    }

    @Override
    public <T> T find(Class<T> entityType, Object key) {
        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityType) {
        return List.of();
    }
}
