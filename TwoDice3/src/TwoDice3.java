import java.util.Scanner;
public class TwoDice3
{
    public static void main(String[] args)
    {
        int userInt = getUserInt();
        Die die1 = new Die();
        Die die2 = new Die();

        for(int i = 0; i < 3; i++)
        {
             die1.setRoll();
             die2.setRoll();

             System.out.println("Die 1 is " + die1.getRoll());
             System.out.println("Die 2 is " + die2.getRoll());

             if((die1.getRoll() + die2.getRoll()) == userInt)
             {
                 System.out.println("You Win!");
                 System.exit(0);
             }
        }
        System.out.println("Computer Wins!");
    }

    private static int getUserInt()
    {
        Scanner input = new Scanner(System.in);
        int userInt;

        do
        {
            System.out.print("Enter your dice total between 2 and 12 >");
            userInt = input.nextInt();
        }
        while(userInt >= 13 || userInt <= 1);

        return userInt;
    }
}
