import java.lang.Math;
public class Die
{
    public int value;
    public static final int MAX = 6;
    public static final int MIN = 1;

    public Die()
    {
        value = ((int)(Math.random() * 100) % MAX + MIN);
    }

    public void setRoll()
    {
        value = ((int)(Math.random() * 100) % MAX + MIN);
    }

    public int getRoll()
    {
        return value;
    }
}
