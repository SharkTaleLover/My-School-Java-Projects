public class Card
{
    private int suit;
    private String rank;
    private int value;

    public Card(int cardSuit, int cardValue)
    {
        suit = cardSuit;
        value = cardValue;
        setValue(cardValue);
    }

    public void setSuit(int cardSuit)
    {
        suit = cardSuit;
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

        switch(value)
        {
            case 1:
                rank = "Ace";
                break;
            case 2:
                rank = "2";
                break;
            case 3:
                rank = "3";
                break;
            case 4:
                rank = "4";
                break;
            case 5:
                rank = "5";
                break;
            case 6:
                rank = "6";
                break;
            case 7:
                rank = "7";
                break;
            case 8:
                rank = "8";
                break;
            case 9:
                rank = "9";
                break;
            case 10:
                rank = "10";
                break;
            case 11:
                rank = "Jack";
                break;
            case 12:
                rank = "Queen";
                break;
            case 13:
                rank = "King";
                break;
        }
    }

    public int getValue()
    {
        return value;
    }

    public String getRank()
    {
        return rank;
    }
}
