package ru.melnikov.Intensive.task.webAPI.servlets;

import ru.melnikov.Intensive.task.webAPI.models.WeatherInfoModel;
import ru.melnikov.Intensive.task.webAPI.services.CurrentWeatherDAO;
import ru.melnikov.Intensive.task.webAPI.utils.connections.someAPI.ConnectionAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Сервлет - точка входа в приложение, создан для удобства пользования.
 */

@WebServlet("/start")
public class MainServlet extends HttpServlet {

    CurrentWeatherDAO currentWeatherDAO;

    @Override
    public void init() throws ServletException {

        currentWeatherDAO = new CurrentWeatherDAO();
    }

    /**
     * При переходе по адресу '/start' пернаправляет клиента на Jsp страницу с кнопкаи - ссылками,
     * которые представляют функционал приложения (получние текущих показателей погоды/получение прогноза на 5 дней)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ДЛя проверки работы метода
        List<WeatherInfoModel> list = currentWeatherDAO.getAllMeasurements();
        for (WeatherInfoModel info: list){
            System.out.println(info.getId());
        }
        getServletContext().getRequestDispatcher("/viewJsp/mainPage.jsp").forward(req, resp);
    }
}
