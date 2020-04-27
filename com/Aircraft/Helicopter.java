package com.Aircraft;

import com.Coordinates;
import com.Simulator;
import com.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(coordinates);

        if (weather == "RAIN")
        {
            coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            Simulator.txtStore.println("Helicopter#" + name + "(" + id + "): " + "I don't like the rain !");
        }
        else if (weather == "FOG")
        {
            coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
            Simulator.txtStore.println("Helicopter#" + name + "(" + id + "): " + "Can't see anything...");
        }
        else if (weather == "SUN")
        {
            coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            Simulator.txtStore.println("Helicopter#" + name + "(" + id + "): " + "Let the sun shine !");
        }
        else if (weather == "SNOW")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            Simulator.txtStore.println("Helicopter#" + name + "(" + id + "): " + "I love snow !");
        }
        if (coordinates.getHeight() == 0)
        {
            weatherTower.unregister(this);
            Simulator.txtStore.println("Helicopter#" + name + "(" + id + "): " + "Landing.");
            Simulator.txtStore.println("Tower says: Helicopter#" + name + "(" + id + ") " + "unregistred from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.txtStore.println("Tower says: Helicopter#" + name + "(" + id + ") " + "registred to weather tower.");
    }
}