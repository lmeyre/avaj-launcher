import java.io.BufferedReader;
import java.io.FileReader;

public class Simulator
{
    static int simulationTime;
    public static void main(String[] args)
    {
        WeatherTower weatherTower = new WeatherTower();
        createReader(args, weatherTower);
        while (simulationTime > 0)
        {
            weatherTower.changeWeather();
            simulationTime--;
        }
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