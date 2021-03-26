import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors2
{

    public static void main(String[] args)
    {
        assignAndDetermine();
    }

    public static void assignAndDetermine() {
        int compChoice = getCompChoice();
        String userInput = "";
        while(userInput != "rock" && userInput != "paper" && userInput != "scissors")
        {
            userInput = getUserInput();
            userInput.toLowerCase();
            if (userInput.charAt(0) == 'r' && userInput.charAt(1) == 'o')
            {
                userInput = "rock";
            } else if (userInput.charAt(0) == 'p' && userInput.charAt(1) == 'a')
            {
                userInput = "paper";
            } else if (userInput.charAt(0) == 's' && userInput.charAt(1) == 'c')
            {
                userInput = "scissors";
            }
        }
        determineWinner(userInput, compChoice);
    }

    public static int getCompChoice()
    {
        Random random = new Random();

        int compChoice = random.nextInt(3) + 1;

        return compChoice;
    }

    public static String getUserInput()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rock, paper, or scissors >");
        String userInput = scanner.nextLine();

        return userInput;
    }

    public static void determineWinner(String user, int comp) {
        String compChoicestring = "No choice";

        if(comp == 1)
            compChoicestring = "rock";
        else if(comp == 2)
            compChoicestring = "paper";
        else if(comp == 3)
            compChoicestring = "scissors";

        if ((user.equals("rock") && compChoicestring.equals("scissors")) || (user.equals("scissors") && compChoicestring.equals("paper")) || (user.equals("paper") && compChoicestring.equals("rock")))
        {
            System.out.println("Computer chose " + compChoicestring);
            System.out.println("You won!");
        }
        else if ((user.equals("rock") && compChoicestring.equals("paper")) || (user.equals("paper") && compChoicestring.equals("scissors")) || (user.equals("scissors") && compChoicestring.equals("rock")))
        {
            System.out.println("Computer chose " + compChoicestring);
            System.out.println("You lost!");
        }
        else if (user.equals(compChoicestring))
        {
            System.out.println("Tie! Try again.");
            assignAndDetermine();
        }
    }
}