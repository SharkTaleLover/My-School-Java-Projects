import java.util.Scanner;
public class Message {
    private static int[][] message = new int[][]

            {{72,65,80,80,89,32,66,73,82,84,72,68,65,89,32,75,89,76,69},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    private static int total = 1294;
    private static int current = 0;
    private static void search(int input)
    {
        for(int i=0; i<message[0].length; i++)
        {
            if(message[1][i]==1 & (message[0][i]!=input || message[0]
                    [i]!=input-32))
            {
                System.out.print((char)message[0][i]);
            }
            else if(message[0][i]==input || message[0][i]==input-32)
            {
                System.out.print((char)message[0][i]);
                message[1][i]=1;
                if(message[0][i]==input)
                {
                    current += input;
                }
                else
                {
                    current += input-32;
                }
            }
            else
            {
                System.out.print((char)32);
            }
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Let's play a game!");
        while(current<total)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a letter:");
            int myInt = keyboard.next().charAt(0);
            search(myInt);
            System.out.println();
        }
        System.out.println("Time for cake!");
    }
}