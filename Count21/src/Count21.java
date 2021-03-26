import java.util.Scanner;
public class Count21
{
    public static void main(String[] args)
    {
        int total = 0;
        int userInt = 0;
        int computerInt = 0;

        while(total < 21)
        {
            computerInt = getComputerInt(total);

            total += computerInt;

            System.out.println("Computer chooses " + computerInt + ". Total is " + total + ".");

            if(total == 21)
            {
                break;
            }

            while(userInt < 1 || userInt > 3)
            {
                userInt = getUserInt("Enter a number between 1 and 3 >");
            }

            total += userInt;

            System.out.println("Total is " + total + ".");

            userInt = 0;
        }

        System.out.println("Computer Wins!");
    }

    public static int getUserInt(String message)
    {
        Scanner input = new Scanner(System.in);

        System.out.print(message);
        return input.nextInt();
    }

    public static int getComputerInt(int total)
    {
        if(total == 0)
        {
            return 1;
        }
        if(total < 5)
        {
            return 5 - total;
        }
        if(total < 9)
        {
            return 9 - total;
        }
        if(total < 13)
        {
            return 13 - total;
        }
        if(total < 17)
        {
            return 17 - total;
        }

        return 21 - total;
    }
}
