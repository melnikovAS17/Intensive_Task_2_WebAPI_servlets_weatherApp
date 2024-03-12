package ru.melnikov.Intensive.task.webAPI.utils.jsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Данный класс является парсером, перобразование JSON'а в Java происходит происходит
 * путём получения из списка JSON нужных элементов по ключу, тк нужно получать
 * данные на 5 дней, упаковывем полученные элементы в массивы
 */
public class JsonParserPrognosisWeather {

    /**
     * Класс библеотеки Jackson необходимый для работы с JSON
     */
    private static JsonNode obj;
    private static ObjectMapper mapper;

    /**
     * Метод возвращает объект JsonNode - объект является всё ещё JSON"ом, создан для удобства
     * написания дальнейших преобразований
     */
    private JsonNode listDays(int day){
        return  obj.get("list").get(day);
    }

    /**
     * Метод преобразует JSON в Java double переменные и добавляет их в массив,
     * тк дней для прогноза 5, соотв и размер массива 5 элементов.
     * Возвращает массив фактических температур
     */
    public double[] getTempListOfEachDay(){
        double[] temperatures = new double[5];
        for (int i = 0; i < 5; i++){
            //-273,15 - тк температура с ресурса приходит в Кельвинах и округляем до 2 наков после запятой
            temperatures[i] = Math.round((listDays(i).get("main").get("temp").asDouble() - 273.15)*100.0)/100.0;
        }
        return temperatures;
    }

    /**
     * Возвращает массив "ощущается как" температур
     */
    public double[] getTemFeelsLikeListOfEachDay(){
        double[] temperaturesFeelsLike = new double[5];
        for (int i = 0; i < 5; i++){
            temperaturesFeelsLike[i] = Math.round((listDays(i).get("main").get("feels_like").asDouble() - 273.15)*100.0)/100.0;
        }
        return temperaturesFeelsLike;
    }


    /**
     * Возвращает массив атмосферных давлений
     */
    public int[] getPressureListOfEachDay(){
        int[] pressure = new int[5];
        for (int i = 0; i < 5; i++){
            pressure[i] = listDays(i).get("main").get("pressure").asInt();
        }
        return pressure;
    }

    /**
     * Возвращает массив влажностей воздуха
     */
    public int[] getHumidityListOfEachDay(){
        int[] humidity = new int[5];
        for (int i = 0; i < 5; i++){
            humidity[i] = listDays(i).get("main").get("humidity").asInt();
        }
        return humidity;
    }

    /**
     * Возвращает массив скоростей ветра
     */
    public double[] getWindSpeedListOfEachDay(){
        double[] speed = new double[5];
        for (int i = 0; i < 5; i++){
            speed[i] = listDays(i).get("wind").get("speed").asDouble();
        }
        return speed;
    }

    /**
     * Данный конструкотр создан с целью атвоматического создания необходимых объектов библеотеки
     * Jackson при создании объекта - парсера, так же конструктор принимает в качетве параметра
     * объект String connection - это есть весь JSON полученный от приложения погоды по Api key,
     * перобразованный в строку
     */
    public JsonParserPrognosisWeather(String connection) throws JsonProcessingException {
            mapper = new ObjectMapper();
            obj = mapper.readTree(connection);
    }
}
