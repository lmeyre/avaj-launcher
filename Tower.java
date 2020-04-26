
import java.util.List;

public class Tower 
{
    private List<Flyable> observers;//To initialize ?

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
        
    }
}