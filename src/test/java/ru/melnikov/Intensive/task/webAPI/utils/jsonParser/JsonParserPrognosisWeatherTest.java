package ru.melnikov.Intensive.task.webAPI.utils.jsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserPrognosisWeatherTest {

    JsonParserPrognosisWeather jsonParserPrognosisWeather;

    @BeforeEach
    public void init() throws JsonProcessingException {

        String jsonText = "{\n" +
                "  \"list\": [\n" +
                "    {\n" +
                "      \"dt\": 1661871600,\n" +
                "      \"main\": {\n" +
                "        \"temp\": 296.76,\n" +
                "        \"feels_like\": 296.98,\n" +
                "        \"temp_min\": 296.76,\n" +
                "        \"temp_max\": 297.87,\n" +
                "        \"pressure\": 1015,\n" +
                "        \"sea_level\": 1015,\n" +
                "        \"grnd_level\": 933,\n" +
                "        \"humidity\": 69,\n" +
                "        \"temp_kf\": -1.11\n" +
                "      },\n" +
                "      \"wind\": {\n" +
                "        \"speed\": 0.62,\n" +
                "        \"deg\": 349,\n" +
                "        \"gust\": 1.18\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        jsonParserPrognosisWeather = new JsonParserPrognosisWeather(jsonText);
    }

    @Test
    void getTemp_whenComesStringInFormatJson_theCorrectValueMustBeReturned() {

        double[] listOfActualTemp = jsonParserPrognosisWeather.getTempListOfEachDay();
        Assertions.assertEquals(1,listOfActualTemp.length);
        Assertions.assertEquals(296.76, listOfActualTemp[0]);
    }

}