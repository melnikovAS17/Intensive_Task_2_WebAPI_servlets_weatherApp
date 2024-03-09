package ru.melnikov.Intensive.task.webAPI.servlets;


import ru.melnikov.Intensive.task.webAPI.utils.connections.Connection;
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
public class GetWeatherByCityNameServlet extends HttpServlet {

    /**
     * Класс Connection содержит в себе механизм подключения по Api key к удалённому ресурсу,
     * который бесплатно предоставляет данные о погоде, создал данный класс,
     * для удобства чтения и управления ресурсами
     */
    Connection connection;

    /**
     * Данный класс является парсерром JSON формата в Java
     */
    JsonParserCurrentDayWeather jsonParserCurrentDayWeather;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // При отправке гет запроса по адресу '/weather' перенаправляет клиента на страницу с формой
        // для ввода города, в котором нужно узнать погоду
        getServletContext().getRequestDispatcher("/viewJsp/formForSelectionCity.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Создание объекта клаасса Connection, который сожержит в себе логику подключения к нужному ресурсу
        connection = new Connection();
        // Получаем параметры с формы, которые передаёт клиент - Город
        String city = req.getParameter("city");
        // Создаём объект - парсер и передаём в него полученный JSON
        jsonParserCurrentDayWeather = new JsonParserCurrentDayWeather(connection.getWeatherAPICurrentValues(city));


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
