package com.Aircraft;

import com.WeatherTower;

public interface Flyable
{
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}