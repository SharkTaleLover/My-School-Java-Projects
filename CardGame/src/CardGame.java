import java.util.*;

public abstract class CardGame
{
    List<Card> deck = new ArrayList<Card>();
    List<Card> cardsDealt = new ArrayList<Card>();

    public CardGame()
    {
        deck.clear();
        for (int suit = 0; suit <= 3; suit++)
            for (int rank = 1; rank <= 13; rank++)
            {
                deck.add(new Card(suit, rank));
            }
    }

    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public abstract void displayDescription();
    public abstract void deal(int cardsToDeal);
}
