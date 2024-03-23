package ru.melnikov.Intensive.task.webAPI.utils.connectionLoadersProp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс для подгрузки Url и Api key с внешних ресурсов
 */
public class PropertiesLoader {

    public static String loadPropertyApi(String propertyName) {
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream(
                "X:\\JavaProjOnIDE\\Intensive.task.webAPI\\src\\main\\resources\\connection.properties")){
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }

    public static String loadPropertyDatabase(String propertyName) {
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream(
                "X:\\JavaProjOnIDE\\Intensive.task.webAPI\\src\\main\\resources\\database.properties")){
            properties.load(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(propertyName);
    }
}