public class LoadedDie extends Die
{
    final static int MIN = 2;
    final static int MAX = 6;

    public LoadedDie()
    {
        value = r.nextInt(MAX + 1 - MIN) + MIN;
    }

    @Override
    public void setRoll()
    {
        value = r.nextInt(MAX + 1 - MIN) + MIN;
    }
}
