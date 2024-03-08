package ru.melnikov.Intensive.task.webAPI.utils.connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Connection {

    public Connection(String city){
        getWeatherAPI(city);
    }
    public Connection(){}

    public String getWeatherAPI(String city){
        return  getConnectionApi("http://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=82ab1d2e43ba360854714aed4aa30b0e&units=metric");
    }

    private static String getConnectionApi(String urlAddress){
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
