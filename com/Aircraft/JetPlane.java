package com.Aircraft;

import com.Coordinates;
import com.Simulator;
import com.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(coordinates);

        if (weather == "RAIN")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
            Simulator.txtStore.println("JetPlane#" + name + "(" + id + "): " + "Flying in the rain make me look badass");
        }
        else if (weather == "FOG")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
            Simulator.txtStore.println("JetPlane#" + name + "(" + id + "): " + "I hope im not hitting a mountain..");
        }
        else if (weather == "SUN")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            Simulator.txtStore.println("JetPlane#" + name + "(" + id + "): " + "Let's get the sunglass and keep it cool.");
        }
        else if (weather == "SNOW")
        {
            coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
            Simulator.txtStore.println("JetPlane#" + name + "(" + id + "): " + "Im loosing height because of the snow !");
        }
        if (coordinates.getHeight() == 0)
        {
            weatherTower.unregister(this);
            Simulator.txtStore.println("JetPlane#" + name + "(" + id + "): " + "Landing.");
            Simulator.txtStore.println("Tower says: JetPlane#" + name + "(" + id + ") " + "unregistred from weather tower.");
        } 
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.txtStore.println("Tower says: JetPlane#" + name + "(" + id + ") " + "registred to weather tower.");
    }
}