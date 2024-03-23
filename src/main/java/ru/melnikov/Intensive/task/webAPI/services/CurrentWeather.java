package ru.melnikov.Intensive.task.webAPI.services;

import ru.melnikov.Intensive.task.webAPI.models.WeatherInfoModel;

import java.util.List;

public interface CurrentWeather {

    void save(WeatherInfoModel weatherInfoModel);

    List<WeatherInfoModel> getAllMeasurements();

}
