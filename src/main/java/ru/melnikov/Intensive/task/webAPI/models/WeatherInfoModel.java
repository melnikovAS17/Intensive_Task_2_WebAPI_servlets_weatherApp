package ru.melnikov.Intensive.task.webAPI.models;

import javax.persistence.*;

@Entity
@Table(name = "weather_indicators")
public class WeatherInfoModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "temp")
    private double temp;

    @Column(name = "temp_feels_like")
    private double tempFeelsLike;

    @Column(name = "pressure")
    private int pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "wind_speed")
    private double windSpeed;

    public int getId() {
        return id;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempFeelsLike() {
        return tempFeelsLike;
    }

    public void setTempFeelsLike(double tempFeelsLike) {
        this.tempFeelsLike = tempFeelsLike;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WeatherInfoModel () {}

    public WeatherInfoModel(double temp, double tempFeelsLike, int pressure, int humidity, double windSpeed) {
        this.temp = temp;
        this.tempFeelsLike = tempFeelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "WeatherInfoModel{" +
                "id=" + id +
                ", temp=" + temp +
                ", tempFeelsLike=" + tempFeelsLike +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
