package ir.ac.kntu;

import java.util.ArrayList;

public class City {
    private String name;
    private Cordinate cordinate;
    private static ArrayList<City> cities = new ArrayList<>();

    public static ArrayList<City> getCities() {
        return cities;
    }

    public static void setCities(ArrayList<City> cities) {
        cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cordinate getCordinate() {
        return cordinate;
    }

    public void setCordinate(Cordinate cordinate) {
        this.cordinate = cordinate;
    }

    public City(String name, Cordinate cordinate) {
        cities.add(this);
        this.name = name;
        this.cordinate = cordinate;
    }

    public City(String name) {
        this.name = name;
    }
}
