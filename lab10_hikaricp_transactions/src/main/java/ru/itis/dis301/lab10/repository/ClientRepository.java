package ru.itis.dis301.lab10.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.itis.dis301.lab10.model.Client;
import ru.itis.dis301.lab10.model.ClientInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    final static Logger logger = LogManager.getLogger(ClientRepository.class);

    private DbWork db = DbWork.getInstance();

    public Client findById(Long id) {
        return null;
    }

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from client natural join client_info ");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ClientInfo clientInfo = new ClientInfo(
                        resultSet.getString("phone"),
                        resultSet.getString("address"),
                        resultSet.getString("passport")
                );

                Client client = new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        clientInfo
                );
                clients.add(client);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public Client addClient(Client client) {

        try {
            Connection connection = db.getConnection();
            // Следующий вызов отменяет отдельные транзакции для каждого запроса
            // и начинает одну общую
            connection.setAutoCommit(false);

            //1. insert into client ... returning id -> id;
            //   insert into client_info (id, ...

            // 2. select nextval('client_seq') -> id
            //   insert into client (id, ...
            //   insert into client_info (id, ...
            Long id = null;
            PreparedStatement statement
                    = connection.prepareStatement("select nextval('client_seq')");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getLong("nextval");
            }
            resultSet.close();

            if (id != null) {
                statement =  connection.prepareStatement(
                        "insert into client (id, name, email) values ( ?, ?, ?)");
                statement.setLong(1, id);
                statement.setString(2, client.getName());
                statement.setString(3, client.getEmail());
                statement.executeUpdate();

                if (client.getClientInfo() != null) {
                    statement =  connection.prepareStatement(
                            "insert into client_info (id, phone, address, passport) values ( ?, ?, ?, ?)");
                    statement.setLong(1, id);
                    statement.setString(2, client.getClientInfo().getPhone());
                    statement.setString(3, client.getClientInfo().getAddress());
                    statement.setString(4, client.getClientInfo().getPassport());
                    statement.executeUpdate();
                }

                statement.close();
                // rollback | commit
                connection.commit();
                db.releasConnection(connection);
                client.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return client;
    }

}
