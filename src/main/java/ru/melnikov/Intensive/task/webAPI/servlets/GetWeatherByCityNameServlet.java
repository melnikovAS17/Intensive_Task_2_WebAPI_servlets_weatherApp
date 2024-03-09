package ru.melnikov.Intensive.task.webAPI.servlets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.melnikov.Intensive.task.webAPI.utils.connections.Connection;
import ru.melnikov.Intensive.task.webAPI.utils.jsonParser.JsonParser;
import ru.melnikov.Intensive.task.webAPI.validator.CityNameValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/weather")
public class GetWeatherByCityNameServlet extends HttpServlet {

    Connection connection;
    JsonParser jsonParser;

    CityNameValidator cityNameValidator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/myJsp/formForSelectionCity.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        connection = new Connection();
        String city = req.getParameter("city");
        cityNameValidator = new CityNameValidator(city);

        if(!cityNameValidator.correctValue()){

            getServletContext().getRequestDispatcher("/myJsp/formForSelectionCity.jsp").forward(req, resp);
        }

        jsonParser = new JsonParser(connection.getWeatherAPI(city));

        //TODO добавить валидацию ActionSupport, добавить тесты, добавить стилей в jsp, добавить коментарии
        //  *попробовать добавить возможность вывода прогноза на 7 дней
        // (url api: api.openweathermap.org/data/2.5/forecast/daily?q=Volgograd&units=metric&cnt=7&appid={API key})
        // в ответе придёт массив, необходимо распарсить по get(0) - понедельник и тд


        req.setAttribute("temp", jsonParser.getTemp());
        req.setAttribute("feels_like", jsonParser.getTempFellsLike());
        req.setAttribute("pressure", jsonParser.getPressure());
        req.setAttribute("humidity", jsonParser.getHumidity());
        req.setAttribute("wind", jsonParser.getWindSpeed());


        getServletContext().getRequestDispatcher("/myJsp/weatherInTheCity.jsp").forward(req, resp);
    }

}
