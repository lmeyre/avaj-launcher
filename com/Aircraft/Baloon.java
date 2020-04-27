package com.Aircraft;

import com.Coordinates;
import com.Simulator;
import com.WeatherTower;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(coordinates);

        if (weather == "RAIN")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            Simulator.txtStore.println("Baloon#" + name + "(" + id + "): " + "Rain is romantic");
        }
        else if (weather == "FOG")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            Simulator.txtStore.println("Baloon#" + name + "(" + id + "): " + "I can't see my feet !");
        }
        else if (weather == "SUN")
        {
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
            Simulator.txtStore.println("Baloon#" + name + "(" + id + "): " + "It's very hot here.");
        }
        else if (weather == "SNOW")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
            Simulator.txtStore.println("Baloon#" + name + "(" + id + "): " + "Ok now it's getting cold.");
        }
        if (coordinates.getHeight() == 0)
        {
            weatherTower.unregister(this);
            Simulator.txtStore.println("Baloon#" + name + "(" + id + "): " + "Landing.");
            Simulator.txtStore.println("Tower says: Baloon#" + name + "(" + id + ") " + "unregistred from weather tower.");
        } 
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.txtStore.println("Tower says: Baloon#" + name + "(" + id + ") " + "registred to weather tower.");
    }
}