package ru.itis.dis301.dockertest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
public class Controller {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    public String test() {

        try {
            Connection connection =
                    DriverManager.getConnection(
                            // адрес БД , имя пользователя, пароль
                            "jdbc:postgresql://172.17.0.1:5432/lab05","postgres","passwd");

            Statement statement =
                    connection.createStatement();

            ResultSet resultSet =
                    statement.executeQuery("select * from country");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Hello from Docker!";
    }
}
