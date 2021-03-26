public class Card2
{
        private Suit.Suits suit;
        private String rank;
        private int value;

        public Card2(Suit.Suits cardSuit, int cardValue)
        {
            suit = cardSuit;
            value = cardValue;
            setValue(cardValue);
        }

        public void setSuit(String cardSuit)
        {
            suit = Suit.Suits.valueOf(cardSuit);
        }

        public Suit.Suits getSuit()
        {
            return suit;
        }

        public void setValue(int val)
        {
            if (val < 1 || val > 52)
            {
                value = 1;
            }
            else
            {
                value = val;
            }

            int subtractor = 0;

            if(value >= 14 && value <= 26)
                subtractor = 13;
            else if(value >= 27 && value <= 39)
                subtractor = 26;
            else if(value >= 40 && value <= 52)
                subtractor = 39;
            switch(value - subtractor)
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
