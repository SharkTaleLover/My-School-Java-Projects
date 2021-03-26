import javax.swing.JOptionPane;

public class RandomGuess3
{
    public static void main(String[] args)
    {
        int number = (1 + (int)(Math.random() * 10));
        int guess;

        do
        {
            guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a number 1-10"));

            if(guess > number)
                JOptionPane.showMessageDialog(null, "Your guess was too high");
            if(guess < number)
                JOptionPane.showMessageDialog(null, "Your guess was too low");
        }
        while(guess != number);

        JOptionPane.showMessageDialog(null, "Your guess was correct");
    }
}
