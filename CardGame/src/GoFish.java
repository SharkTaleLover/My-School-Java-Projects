public class GoFish extends CardGame
{
    Player[] players;
    final static int CARDS_TO_DEAL = 7;

    public GoFish(int gamePlayers)
    {
        super();
        players = new Player[gamePlayers];
        shuffle();
        for(int i = 0; i < gamePlayers; i++)
        {
            players[i] = new Player(CARDS_TO_DEAL);
        }
        deal(CARDS_TO_DEAL);
    }

    public void deal(int cardsToDeal)
    {
        for(int i = 0; i < players.length; i++)
            for(int j = 0; j < cardsToDeal; j++)
            {
                players[i].hand[j] = deck.get(0);
                cardsDealt.add(deck.get(0));
                deck.remove(0);
            }
    }

    public void displayDescription()
    {
        System.out.println("There are " + players.length + " players, cards will be listed as (Rank) of (Suit) with suit 0 being Spades and suit 0 being Clubs");
        for(int a = 0; a < players.length; a++)
        {
            System.out.println("Player " + (a+1) + " has a deck of: ");
            for(int b = 0; b < CARDS_TO_DEAL; b++)
            {
                System.out.println("Card " + (b+1) + ":   " + players[a].hand[b].getRank() + " of " + players[a].hand[b].getSuit());
            }
        }
    }
}
