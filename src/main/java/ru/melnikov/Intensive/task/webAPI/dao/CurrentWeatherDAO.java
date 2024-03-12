package ru.melnikov.Intensive.task.webAPI.dao;

import ru.melnikov.Intensive.task.webAPI.utils.connections.postgreSQL.ConnectionPostgreSQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Класс является сервисом взаимодействия с бд, может включать в себя CRUD методы, а также включает в себя
 * объект подключения к базе данных postgreSQL
 */
public class CurrentWeatherDAO {

    private final ConnectionPostgreSQL connectionPostgreSQL;

    public CurrentWeatherDAO() {
        connectionPostgreSQL = new ConnectionPostgreSQL();
    }

    /**
     * Пример метода вставки данных в таблицу бд (метод принимает в аргументы температуру и записывает в бд)
     */
    public void save(double temp){
        try {
            PreparedStatement preparedStatement =
            connectionPostgreSQL.getConnection().prepareStatement(
                    "INSERT INTO temperature(tmep) values(?) ");
            preparedStatement.setDouble(1,temp);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
