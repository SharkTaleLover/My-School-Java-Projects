import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors
{

    public static void main(String[] args)
    {
        assignAndDetermine();
    }

    public static void assignAndDetermine() {
        int compChoice = getCompChoice();
        int userInput = getUserInput();

        determineWinner(userInput, compChoice);
    }

    public static int getCompChoice()
    {
        Random random = new Random();

        int compChoice = random.nextInt(3) + 1;

        return compChoice;
    }

    public static int getUserInput()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter choice: 1 for rock, 2 for paper, 3 for scissors >");
        int userInput = scanner.nextInt();

        return userInput;
    }

    public static void determineWinner(int user, int comp) {
        String compChoicestring = "No choice";

        if(comp == 1)
            compChoicestring = "Rock";
        else if(comp == 2)
            compChoicestring = "Paper";
        else if(comp == 3)
            compChoicestring = "Scissors";

        if (user - comp == 1 || user - comp == -2)
        {
            System.out.println("Computer chose " + compChoicestring);
            System.out.println("You won!");
        }
        else if (user - comp == -1 || user - comp == 2)
        {
            System.out.println("Computer chose " + compChoicestring);
            System.out.println("You lost!");
        }
        else if (user == comp)
        {
            System.out.println("Tie! Try again.");
            assignAndDetermine();
        }
    }

}
