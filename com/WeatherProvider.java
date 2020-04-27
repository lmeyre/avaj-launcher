package com;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider;
    private String[] weather;

    private WeatherProvider()
    {
        weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getProvider()
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        int coordPos = coordinates.getHeight() + coordinates.getLatitude() * 2 + coordinates.getLongitude() * 3;
        return weather[coordPos % 4];
    }
}