package ru.melnikov.Intensive.task.webAPI.utils.jsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Данный класс является парсером, перобразование JSON'а в Java происходит происходит
 * путём получения из списка JSON нужных элементов по ключу
 */
public class JsonParserCurrentDayWeather {

    /**
     * Класс библеотеки Jackson необходимый для работы с JSON
     */
    private final JsonNode obj;

    /**
     * Метод возвращает фактическую температуру
     */
    public double getTemp(){
        return  obj.get("main").get("temp").asDouble();
    }

    /**
     * Метод возвращает "ощущается как" температуру или "показатель насколько данная температура комфортна"
     */
    public double getTempFellsLike(){
        return obj.get("main").get("feels_like").asDouble();
    }

    /**
     * Метод возвращает атмосферное давление
     */
    public int getPressure(){
        return obj.get("main").get("pressure").asInt();
    }

    /**
     * Метод возвращает влажность воздуха
     */
    public int getHumidity(){
        return obj.get("main").get("humidity").asInt();
    }

    /**
     * Метод возвращает скорость ветра
     */
    public double getWindSpeed(){
        return obj.get("wind").get("speed").asDouble();
    }


    /**
     * Данный конструкотр создан с целью атвоматического создания необходимых объектов библеотеки
     * Jackson при создании объекта - парсера, так же конструктор принимает в качетве параметра
     * объект String connection - это есть весь JSON полученный от приложения погоды по Api key,
     * перобразованный в строку
     */
    public JsonParserCurrentDayWeather(String connection) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
         obj = mapper.readTree(connection);
    }

}
