import java.util.Random;
public class War2
{
    public static void main(String[] args) {
        final int CARDS_IN_SUIT = 13;
        Card card1 = new Card();
        Card card2 = new Card();
        Random rand = new Random();

        // I know I should use a method for this but I'm on a time crunch here
        switch((rand.nextInt(4) + 1))
        {
            case 1:
                card1.setSuit("Spades");
                break;
            case 2:
                card1.setSuit("Hearts");
                break;
            case 3:
                card1.setSuit("Diamonds");
                break;
            case 4:
                card1.setSuit("Clubs");
                break;
        }
        card1.setValue(rand.nextInt(13) + 1);
        switch((rand.nextInt(4) + 1))
        {
            case 1:
                card2.setSuit("Spades");
                break;
            case 2:
                card2.setSuit("Hearts");
                break;
            case 3:
                card2.setSuit("Diamonds");
                break;
            case 4:
                card2.setSuit("Clubs");
                break;
        }
        card2.setValue(rand.nextInt(13) + 1);

        while(card1.getSuit() == card2.getSuit())
        {
            switch((rand.nextInt(4) + 1))
            {
                case 1:
                    card1.setSuit("Spades");
                    break;
                case 2:
                    card1.setSuit("Hearts");
                    break;
                case 3:
                    card1.setSuit("Diamonds");
                    break;
                case 4:
                    card1.setSuit("Clubs");
                    break;
            }
        }

        System.out.println("Player 1 card is the:"+card1.getRank()+" of "+card1.getSuit());
        System.out.println("Player 2 card suit:"+card2.getRank()+" of "+card2.getSuit());

        if(card1.getValue() > card2.getValue())
        {
            System.out.println("Player 1 won");
        }
        else if(card1.getValue() < card2.getValue())
        {
            System.out.println("Player 2 won");
        }
        else
        {
            System.out.println("It was a tie");
        }
    }
}
