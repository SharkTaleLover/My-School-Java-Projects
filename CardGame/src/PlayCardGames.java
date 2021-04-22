public class PlayCardGames
{
    public static void main(String[] args)
    {
        System.out.println("Go Fish:");
        GoFish goFish = new GoFish(2);
        goFish.displayDescription();

        System.out.println("War:");
        War war = new War();
        war.displayDescription();
    }
}
