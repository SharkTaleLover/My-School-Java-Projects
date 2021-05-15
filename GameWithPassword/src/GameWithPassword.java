import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.CREATE;

public class GameWithPassword
{
    public static void main(String[] args)
    {
        boolean userExists = false;
        try
        {
            Path userDataFile = Paths.get("Data.txt");
            InputStream input = new BufferedInputStream(Files.newInputStream(userDataFile, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String id;
            String password;
            String delimiter = ",";
            String s = "";
            String[] array;

            String userId = JOptionPane.showInputDialog(null, "Please enter an id, example: User");
            String userPassword = JOptionPane.showInputDialog(null, "Please enter a password, example: password");

            while((s = reader.readLine()) != null)
            {
                array = s.split(delimiter);
                id = array[0];
                password = array[1];
                if(id.equals(userId) && password.equals(userPassword))
                {
                    userExists = true;
                    break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
        if(!userExists)
        {
            JOptionPane.showMessageDialog(null, "Incorrect id and/or password.");
            System.exit(0);
        }
        else
            JOptionPane.showMessageDialog(null, "Id and password accepted, please enjoy the game.");
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
