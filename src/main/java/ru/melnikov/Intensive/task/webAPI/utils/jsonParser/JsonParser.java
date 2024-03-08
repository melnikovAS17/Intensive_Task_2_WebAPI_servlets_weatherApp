package ru.melnikov.Intensive.task.webAPI.utils.jsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    private final JsonNode obj;

    private double temp;

    public double getTemp(){
        return  obj.get("main").get("temp").asDouble();
    }

    public double getTempFellsLike(){
        return obj.get("main").get("feels_like").asDouble();
    }

    public int getPressure(){
        return obj.get("main").get("pressure").asInt();
    }

    public int getHumidity(){
        return obj.get("main").get("humidity").asInt();
    }

    public double getWindSpeed(){
        return obj.get("wind").get("speed").asDouble();
    }


    public JsonParser(String connection) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
         obj = mapper.readTree(connection);
    }

}
