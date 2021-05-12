import java.nio.file.*;
import java.io.*;
import static java.nio.file.AccessMode.*;
public class DisplaySavedCustomerList {
    public static void main(String[] args) {
        try
        {
            String s;
            InputStream input = new BufferedInputStream(Files.newInputStream(WriteCustomerList.file.toPath()));
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            while((s = br.readLine()) != null)
            {
                System.out.println(s);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}

