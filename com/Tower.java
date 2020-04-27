package com;

import com.Aircraft.Flyable;
import java.util.List;
import java.util.ArrayList;

public class Tower 
{
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
    }

    protected void conditionChanged()
    {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
        }
    }
}