package ru.melnikov.Intensive.task.webAPI.servlets;


import ru.melnikov.Intensive.task.webAPI.dao.CurrentWeatherDAO;
import ru.melnikov.Intensive.task.webAPI.utils.connections.someAPI.ConnectionAPI;
import ru.melnikov.Intensive.task.webAPI.utils.jsonParser.JsonParserCurrentDayWeather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для получения показателей погоды на текущий момент, в выбранном городе
 */

@WebServlet("/weather")
public class GetCurrentWeatherByCityNameServlet extends HttpServlet {

    /**
     * Класс Connection содержит в себе механизм подключения по Api key к удалённому ресурсу,
     * который бесплатно предоставляет данные о погоде, создал данный класс,
     * для удобства чтения и управления ресурсами
     */
    ConnectionAPI connectionAPI;

    CurrentWeatherDAO currentWeatherDAO;
    /**
     * Данный класс является парсерром JSON формата в Java
     */
    JsonParserCurrentDayWeather jsonParserCurrentDayWeather;

    @Override
    public void init() throws ServletException {
        // Создание объекта клаасса Connection, который сожержит в себе логику подключения к нужному ресурсу
        connectionAPI = new ConnectionAPI();
        currentWeatherDAO = new CurrentWeatherDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // При отправке гет запроса по адресу '/weather' перенаправляет клиента на страницу с формой
        // для ввода города, в котором нужно узнать погоду
        getServletContext().getRequestDispatcher("/viewJsp/formForSelectionCity.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получаем параметры с формы, которые передаёт клиент - Город
        String city = req.getParameter("city");
        // Создаём объект - парсер и передаём в него полученный JSON
        jsonParserCurrentDayWeather = new JsonParserCurrentDayWeather(connectionAPI.getWeatherAPICurrentValues(city));


        // Устанавливаем преобразованные данные в атрибуты для дальнейшего отображения в Jsp
        req.setAttribute("temp", jsonParserCurrentDayWeather.getTemp());
        req.setAttribute("feels_like", jsonParserCurrentDayWeather.getTempFellsLike());
        req.setAttribute("pressure", jsonParserCurrentDayWeather.getPressure());
        req.setAttribute("humidity", jsonParserCurrentDayWeather.getHumidity());
        req.setAttribute("wind", jsonParserCurrentDayWeather.getWindSpeed());

        // Перенаправляем клиента на сраницу с результатами погоды в указанном городе
        getServletContext().getRequestDispatcher("/viewJsp/weatherInTheCity.jsp").forward(req, resp);
    }

}
