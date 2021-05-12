import java.nio.file.*;
import java.io.*;
import static java.nio.file.AccessMode.*;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.CREATE;
public class WriteCustomerList {

    public static File file = new File("CustomerList.txt");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "";
        String delimiter = ",";
        String QUIT = "ZZZ";
        int id;
        String idString;
        String firstName;
        String lastName;
        double pay;

        try
        {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file.toPath(), CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            System.out.print("Enter employee id >");
            idString = input.nextLine();
            while(!idString.equals(QUIT))
            {
                id = Integer.parseInt(idString);
                System.out.print("Enter first name >");
                firstName = input.nextLine();
                System.out.print("Enter last name >");
                lastName = input.nextLine();
                System.out.print("Enter pay >");
                pay = input.nextDouble();
                s = id + delimiter + firstName + delimiter + lastName + delimiter + pay;
                writer.write(s, 0, s.length());
                writer.newLine();
                System.out.print("Enter next id or " + QUIT + " to quit >");
                input.nextLine();
                idString = input.nextLine();
            }
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}
