import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class DisplayRentalFile
{
    public static void displayFile()
    {
        try
        {
            Path rentalsFile = Paths.get("Rentals.txt");
            InputStream in = new BufferedInputStream(Files.newInputStream(rentalsFile, CREATE));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String s = "";

            while ((s = reader.readLine()) != null)
            {
                System.out.println(s);
            }
            reader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}
