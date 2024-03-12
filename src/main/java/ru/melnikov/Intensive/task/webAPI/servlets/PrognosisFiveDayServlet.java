package ru.melnikov.Intensive.task.webAPI.servlets;

import ru.melnikov.Intensive.task.webAPI.utils.connections.someAPI.ConnectionAPI;
import ru.melnikov.Intensive.task.webAPI.utils.jsonParser.JsonParserPrognosisWeather;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Сервлет для получения прогноза погоды на 5 дней, в выбранном городе
 */
@WebServlet("/prognosis")
public class PrognosisFiveDayServlet extends HttpServlet {

    /**
     * Класс Connection содержит в себе механизм подключения по Api key к удалённому ресурсу,
     * который бесплатно предоставляет данные о погоде, создал данный класс,
     * для удобства чтения и управления ресурсами
     */
    ConnectionAPI connectionAPI;

    /**
     * Данный класс является парсерром JSON формата в Java, имеет функционал необходимый для
     * париснга данных по дням, тк JSON приходит в формате массива с погодой для каждого дня
     */
    JsonParserPrognosisWeather jsonParserPrognosisWeather;

    @Override
    public void init() throws ServletException {
        // Создание объекта клаасса Connection, который сожержит в себе логику подключения к нужному ресурсу

        connectionAPI = new ConnectionAPI();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // При отправке гет запроса по адресу '/prognosis' перенаправляет клиента на страницу с формой
        // для ввода города, по которому нужно получить прогноз
        getServletContext().getRequestDispatcher("/viewJsp/formForSelectionCityPrognosis.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получаем параметры с формы, которые передаёт клиент - Город
        String city = req.getParameter("city");
        // Создаём объект - парсер и передаём в него полученный JSON
        jsonParserPrognosisWeather = new JsonParserPrognosisWeather(connectionAPI.getWeatherAPIPrognosis(city));
        // Устанавливаем преобразованные данные в атрибуты для дальнейшего отображения в Jsp
        req.setAttribute("temp", jsonParserPrognosisWeather.getTempListOfEachDay());
        req.setAttribute("feels_like", jsonParserPrognosisWeather.getTemFeelsLikeListOfEachDay());
        req.setAttribute("pressure", jsonParserPrognosisWeather.getPressureListOfEachDay());
        req.setAttribute("humidity", jsonParserPrognosisWeather.getHumidityListOfEachDay());
        req.setAttribute("wind", jsonParserPrognosisWeather.getWindSpeedListOfEachDay());
        // Перенаправляем клиента на сраницу с результатами прогноза погоды в указанном городе
        getServletContext().getRequestDispatcher("/viewJsp/weatherInTheCityPrognosis.jsp").forward(req, resp);
    }
}
