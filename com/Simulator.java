package com;

import com.Aircraft.Flyable;
import java.io.BufferedReader;
import java.io.*;

public class Simulator
{
    public static PrintWriter txtStore;
    static int simulationTime;

    public static void main(String[] args)
    {   

        File simulationFile = new File("simulation.txt");
        try
        {
            txtStore = new PrintWriter(simulationFile);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        if (simulationFile.exists())
            txtStore.print("");
        WeatherTower weatherTower = new WeatherTower();
        createReader(args, weatherTower);
        while (simulationTime > 0)
        {
            weatherTower.changeWeather();
            simulationTime--;
        }
        txtStore.close();
    }

    private static void createReader(String[] args, WeatherTower weatherTower)
    {
        BufferedReader reader = null;
        if (args.length != 1)
        {
            if (args.length < 1)
                System.out.println("Missing argument !");
            else
                System.out.println("Too many arguments !");
            System.exit(0);
        }
        try
        {
            reader = new BufferedReader(new FileReader(args[0]));
            simulationTime = Integer.parseInt(reader.readLine());
        }
        catch(Exception e)
        {
            System.out.println("Couldn't read file : " + e.getMessage());
            System.exit(0);
        }
        createAircrafts(reader, weatherTower);
    }

    private static void createAircrafts(BufferedReader reader, WeatherTower weatherTower)
    {
        AircraftFactory factory = new AircraftFactory();
        String[] datas;
        String currAircraft;
        int line = 2;
        try
        {
            while ((currAircraft = reader.readLine()) != null)
            {
                datas = currAircraft.split(" ");
                if (datas.length != 5)
                {
                    System.out.println("Wrong aircraft parameters in line " + line);
                    System.exit(0);
                }
				Flyable aircraft = factory.newAircraft(datas[0], datas[1], Integer.parseInt(datas[2]),
                    Integer.parseInt(datas[3]), Integer.parseInt(datas[4]));
                if (aircraft == null)
                {
                    System.out.println("Wrong aircraft type");
                    System.exit(0);
                }
                aircraft.registerTower(weatherTower);
                line++;
			}
			reader.close();
        }
        catch (Exception e)
        {
            System.out.println("Problem in the aircraft lines " + line + " -> " + e.getMessage());
        }
    }
}