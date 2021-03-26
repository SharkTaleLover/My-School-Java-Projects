import java.util.*;
public class TicTacToe
{
    private static char[] spots = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args)
    {
        System.out.println("Welcome to Tic Tac Toe, you will be Xs.");
        System.out.println();

        for(int i = 0; i < 5; i++)
        {
            spots[getUserChoice() - 1] = 'X';
            if(gameIsOver('X'))
            {
                displayTicTacToe();
                System.out.println("You Won");
                break;
            }

            if(i == 4)
            {
                break;
            }
            spots[getComputerChoice() - 1] = 'O';
            if(gameIsOver('O'))
            {
                displayTicTacToe();
                System.out.println("Computer Won");
                break;
            }
        }
    }

    private static boolean gameIsOver(char userOrComp)
    {
        if(spots[0] == userOrComp && spots[1] == userOrComp && spots[2] == userOrComp)
        {
            return true;
        }
        else if(spots[3] == userOrComp && spots[4] == userOrComp && spots[5] == userOrComp)
        {
            return true;
        }
        else if(spots[6] == userOrComp && spots[7] == userOrComp && spots[8] == userOrComp)
        {
            return true;
        }
        else if(spots[0] == userOrComp && spots[3] == userOrComp && spots[6] == userOrComp)
        {
            return true;
        }
        else if(spots[1] == userOrComp && spots[4] == userOrComp && spots[7] == userOrComp)
        {
            return true;
        }
        else if(spots[2] == userOrComp && spots[5] == userOrComp && spots[8] == userOrComp)
        {
            return true;
        }
        else if(spots[6] == userOrComp && spots[4] == userOrComp && spots[2] == userOrComp)
        {
            return true;
        }
        else if(spots[1] == userOrComp && spots[4] == userOrComp && spots[8] == userOrComp)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static int getComputerChoice()
    {
        int compInt = 0;

        do
        {
            compInt = (int)(Math.random() * 9 + 1);
        } while(checkIfFilled(compInt));

        return compInt;
    }

    public static int getUserChoice()
    {
        Scanner input = new Scanner(System.in);
        int userInt = 0;

        displayTicTacToe();

        System.out.print("Enter a number for your space >");

        userInt = input.nextInt();
        while(userInt > 9 || userInt < 1 || checkIfFilled(userInt))
        {
            System.out.println("Try again >");
            userInt = input.nextInt();
        }

        return userInt;
    }

    private static void displayTicTacToe()
    {
        System.out.println(spots[0] + " " + spots[1] + " " + spots[2] + " ");
        System.out.println(spots[3] + " " + spots[4] + " " + spots[5] + " ");
        System.out.println(spots[6] + " " + spots[7] + " " + spots[8] + " ");
    }

    private static boolean checkIfFilled(int check)
    {
        if(spots[check - 1] == 'X' || spots[check - 1] == 'O')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
