import java.util.Random;
public class War
{
    public static void main(String[] args) {
        final int CARDS_IN_SUIT = 13;
        Card card1 = new Card();
        Card card2 = new Card();
        Random rand = new Random();

        card1.setSuit(rand.nextInt(4) + 1);
        card1.setValue(rand.nextInt(13) + 1);
        card2.setSuit(rand.nextInt(4) + 1);
        card2.setValue(rand.nextInt(13) + 1);

        if(card1.getSuit() == card2.getSuit())
        {
            card1.setSuit(rand.nextInt(4) + 1);
        }

        System.out.println("Player card suit:"+card1.getSuit()+"\nvalue:"+card1.getValue());
        System.out.println("Computer card suit:"+card2.getSuit()+"\nvalue:"+card2.getValue());

        if(card1.getValue() > card2.getValue())
        {
            System.out.println("Player won");
        }
        else if(card1.getValue() < card2.getValue())
        {
            System.out.println("Computer won");
        }
        else
        {
            System.out.println("It was a tie");
        }
    }
}
