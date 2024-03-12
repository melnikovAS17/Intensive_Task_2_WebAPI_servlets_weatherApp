package ru.melnikov.Intensive.task.webAPI.utils.connections.someAPI;

import ru.melnikov.Intensive.task.webAPI.utils.connection.properties.PropertiesLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;

/**
 * Данный класс содержит в себе функционал подключения серверного приложения (this) к
 * удалённому рессурсу с погодными показателями, подключение - есть запрос
 * по определённому адрессу и передачи необходимых параметров (например: Api key)
 */


public class ConnectionAPI {

    /**
     * Два конструктора для удобства полльзования классом
     */
    public ConnectionAPI(String city){
        getWeatherAPICurrentValues(city);
    }
    public ConnectionAPI(){}

    /**
     * Методы ниже являются конекторами, принимающими в качестве параметра названия города,
     * погоду в котором нужно получить, возвращают строку String, в которой написан код в
     * формате JSON пришедший от удалённого ресурса
     */

    /**
     * Данный метод возвращает данные о текущей погоде в выбранном городе
     */
    public String getWeatherAPICurrentValues(String city){
        return  getApiResourcesMessage(PropertiesLoader.loadPropertyApi("url.api.current.weather")
                + city + PropertiesLoader.loadPropertyApi("api.key"));
    }

    /**
     * Данный метод возвращает прогноз погоды на 5 дней в выбранном городе
     */
    public String getWeatherAPIPrognosis(String city){
        return  getApiResourcesMessage(PropertiesLoader.loadPropertyApi("url.api.forecast.weather") +
                city + PropertiesLoader.loadPropertyApi("api.key"));
    }

    /**
     * Данный метод является основным узлом коннекта с ресурсом погоды,
     * устанавливает свзяьщ между приложениями по URL и открывает поток чтения,
     * считывая JSON, добавляет его элементы в строку (использован StringBuilder).
     */
    private static String getApiResourcesMessage(String urlAddress){
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlAddress);
            URLConnection urlConn = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(content.toString());
        return content.toString();
    }
}
