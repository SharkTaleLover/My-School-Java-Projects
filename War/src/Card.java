public class Card
{

    private int suit;
    private int value;

    public void setSuit(int s)
    {
        suit = s;
    }

    public int getSuit()
    {
        return suit;
    }

    public void setValue(int val)
    {
        if (val < 1 || val > 13)
        {
            value = 1;
        }
        else
        {
            value = val;
        }
    }

    public int getValue()
    {
        return value;
    }
}