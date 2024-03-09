package ru.melnikov.Intensive.task.webAPI.utils.connection.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс для подгрузки Url и Api key с внешних ресурсов
 */
public class PropertiesLoader {

    public static String loadProperty(String propertyName) {
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream(
                "X:\\JavaProjOnIDE\\Intensive.task.webAPI\\src\\main\\resources\\connection.properties")){
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}