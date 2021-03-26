import java.time.chrono.MinguoChronology;
import java.util.Random;
public class Die
{
    int value;
    final static int MAX = 6;
    final static int MIN = 1;
    Random r = new Random();

    public Die()
    {
        value = r.nextInt(MAX + 1 - MIN) + MIN;
    }

    public void setRoll()
    {
        value = r.nextInt(MAX + 1 - MIN) + MIN;
    }

    public int getRoll()
    {
        return value;
    }
}
