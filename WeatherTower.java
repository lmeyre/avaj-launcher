
public class WeatherTower extends Tower
{
    WeatherProvider weatherProvider;

    WeatherTower()
    {
        weatherProvider = WeatherProvider.getProvider();
    }

    public String getWeather(Coordinates coordinates)
    {
        return weatherProvider.getCurrentWeather(coordinates);
    }

    void changeWeather()
    {
        conditionChanged();
    }
}