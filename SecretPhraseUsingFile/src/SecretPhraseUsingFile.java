import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.*;

import static java.nio.file.StandardOpenOption.*;

public class SecretPhraseUsingFile
{
    public static void main(String[] args)
    {
        List<String> words = readGuessFile();
        if(words.isEmpty())
        {
            System.out.println("File is empty, please make sure there is text in the file.");
            System.exit(0);
        }
        boolean playAgain = true;
        while(playAgain)
        {
            words = startGame(words);
            if(words.isEmpty())
                break;
            playAgain = askPlayAgain();
        }
    }

    public static List<String> readGuessFile()
    {
        Path phrasesFile = Paths.get("Phrases.txt");
        List<String> guessWords = new ArrayList<String>();
        String s = "";
        try
        {
            InputStream input = new BufferedInputStream(Files.newInputStream(phrasesFile, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            while((s = reader.readLine()) != null)
            {
                guessWords.add(s);
            }
            reader.close();
            return guessWords;
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
            return null;
        }
    }

    private static List<String> startGame(List<String> words)
    {
        Collections.shuffle(words);
        String word = words.get(0);
        word = word.toUpperCase();
        words.remove(0);
        boolean wordGuessed = false;
        StringBuilder solvingWord = new StringBuilder();

        for(int k = 0; k < word.length(); k++)
            solvingWord.append("-");

        while(!wordGuessed)
        {
            char guess = getUserGuess();
            solvingWord = checkGuess(word, guess, solvingWord);
            System.out.println(solvingWord);
            wordGuessed = true;
            for(int i = 0; i < word.length(); i++)
            {
                if(solvingWord.charAt(i) == '-')
                    wordGuessed = false;
            }
        }
        System.out.println("You guessed the word!");
        return words;
    }

    private static char getUserGuess()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character to guess, use _ for spaces >");
        return Character.toUpperCase(input.next().charAt(0));
    }

    private static StringBuilder checkGuess(String word, char guess, StringBuilder empty)
    {
        for(int j = 0; j < word.length(); j++)
        {
            if(word.charAt(j) == guess)
                empty.setCharAt(j, guess);
        }
        return empty;
    }

    private static boolean askPlayAgain()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to play again? Type Y or N >");
        if(input.next().charAt(0) == 'Y')
            return true;
        else
            return false;
    }
}
