package ru.melnikov.Intensive.task.webAPI.validator;

public class CityNameValidator {


    private String city;


    public boolean correctValue(){
        char[] symbol = city.toCharArray();
        if(symbol.length < 2 || symbol.length >= 36){
            return false;
        }
        return true;
    }

    public CityNameValidator(String city){
        setCity(city);
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
