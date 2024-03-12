package ru.melnikov.Intensive.task.webAPI.utils.connections.postgreSQL;

import ru.melnikov.Intensive.task.webAPI.utils.connection.properties.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Данный класс является классом подключения к бд, вынес Connection в отдельный класс для
 * удобства восприятия и унификации объекта подключения
 */
public class ConnectionPostgreSQL {
    private final Connection connection;
    public ConnectionPostgreSQL() {
            {
            try {
                Class.forName(PropertiesLoader.loadPropertyDatabase("database.driver"));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                connection = DriverManager.getConnection(
                        PropertiesLoader.loadPropertyDatabase("database.url"),
                        PropertiesLoader.loadPropertyDatabase("database.username"),
                        PropertiesLoader.loadPropertyDatabase("database.password"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
