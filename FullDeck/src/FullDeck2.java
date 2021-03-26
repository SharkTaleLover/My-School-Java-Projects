public class FullDeck2
{
    private static Card2[] deck = new Card2[52];

    public static void main(String[] args)
    {
        for(int i = 0; i < 13; i++)
        {
            deck[i] = new Card2(Suit.Suits.SPADES, i + 1);
        }
        for(int j = 13; j < 26; j++)
        {
            deck[j] = new Card2(Suit.Suits.HEARTS, j + 1);
        }
        for(int k = 26; k < 39; k++)
        {
            deck[k] = new Card2(Suit.Suits.DIAMONDS, k + 1);
        }
        for(int l = 39; l < 52; l++)
        {
            deck[l] = new Card2(Suit.Suits.CLUBS, l + 1);
        }
        displayDeck();
    }

    public static void displayDeck()
    {
        System.out.println("Rank:       Suit:");
        for(int i = 0; i < deck.length; i++)
        {
            System.out.print(i + 1 + ": " + deck[i].getRank() + " of " + deck[i].getSuit().toString());
            System.out.println();
        }
    }
}
