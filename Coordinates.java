
public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        longitude = (longitude < 0 ? 0 : longitude);
        latitude = (latitude < 0 ? 0 : latitude);
        height = (height < 0 ? 0 : height);
        height = (height > 100 ? 100 : height);
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude()
    {
        return longitude;
    }

    public int getLatitude()
    {
        return latitude;
    }

    public int getHeight()
    {
        return height;
    }
}