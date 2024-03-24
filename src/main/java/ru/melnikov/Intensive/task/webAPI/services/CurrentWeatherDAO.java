package ru.melnikov.Intensive.task.webAPI.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.melnikov.Intensive.task.webAPI.models.WeatherInfoModel;

import java.util.ArrayList;
import java.util.List;


public class CurrentWeatherDAO implements CurrentWeather {
    Configuration configuration = new Configuration().addAnnotatedClass(WeatherInfoModel.class);
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();

    @Override
    public void save(WeatherInfoModel weatherInfoModel){
            session.beginTransaction();
            session.save(weatherInfoModel);
            session.getTransaction().commit();
    }
    @Override
    public List<WeatherInfoModel> getAllMeasurements(){
        List<WeatherInfoModel> weatherInfoModelsList;
            session.beginTransaction();
            weatherInfoModelsList = session.createQuery("from WeatherInfoModel").list();
            session.getTransaction().commit();
        return weatherInfoModelsList;
    }

}
