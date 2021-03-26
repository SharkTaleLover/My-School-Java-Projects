import java.awt.*;
import java.util.*;
public class RockPaperScissors3
{
    private static enum Choices {ROCK, PAPER, SCISSORS};

    public static void main(String[] args)
    {
        assignAndDetermine();
    }

    public static void assignAndDetermine() {
        Choices compChoice = getCompChoice();
        Choices userInput = getUserInput();

        determineWinner(userInput, compChoice);
    }

    public static Choices getCompChoice()
    {
        Random random = new Random();

        int compChoice = random.nextInt(3) + 1;

        switch (compChoice)
        {
            case 1:
                return Choices.ROCK;
            case 2:
                return Choices.PAPER;
            case 3:
                return Choices.SCISSORS;
        }

        return Choices.ROCK;
    }

    public static Choices getUserInput()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rock, paper, or scissors >");
        String userInput = scanner.nextLine();
        userInput = userInput.toUpperCase();

        return Choices.valueOf(userInput);
    }

    public static void determineWinner(Choices user, Choices comp) {
        if ((user.equals(Choices.ROCK) && comp.equals(Choices.SCISSORS)) || (user.equals(Choices.SCISSORS) && comp.equals(Choices.PAPER)) || (user.equals(Choices.PAPER) && comp.equals(Choices.ROCK)))
        {
            System.out.println("Computer chose " + comp.toString());
            System.out.println("You won!");
        }
        else if ((user.equals(Choices.ROCK) && comp.equals(Choices.PAPER)) || (user.equals(Choices.PAPER) && comp.equals(Choices.SCISSORS)) || (user.equals(Choices.SCISSORS) && comp.equals(Choices.ROCK)))
        {
            System.out.println("Computer chose " + comp);
            System.out.println("You lost!");
        }
        else if (user.equals(comp))
        {
            System.out.println("Tie! Try again.");
            assignAndDetermine();
        }
    }
}