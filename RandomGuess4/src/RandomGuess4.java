import javax.swing.*;
import java.util.*;

public class RandomGuess4
{
    public static void main(String[] args)
    {
        int number = (1 + (int)(Math.random() * 10));
        int guess = 0;

        do
        {
            boolean valid = false;
            do
            {
                try
                {
                    guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number 1-10"));
                    valid = true;
                }
                catch (NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null, "Please enter an integer");
                }
            } while(!valid);
            if(guess > number)
                JOptionPane.showMessageDialog(null, "Your guess was too high");
            if(guess < number)
                JOptionPane.showMessageDialog(null, "Your guess was too low");
        }
        while(guess != number);

        JOptionPane.showMessageDialog(null, "Your guess was correct");
    }
}