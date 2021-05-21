import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileIoTest
{
    public static void main(String[] args)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\kylec\\OneDrive\\Desktop\\Stuff\\Folders and Files\\java\\Projects\\My-School-Java-Projects\\FileIOTest\\output-copy.txt"));
            BufferedReader br = new BufferedReader(
                    new FileReader("C:\\Users\\kylec\\OneDrive\\Desktop\\Stuff\\Folders and Files\\java\\Projects\\My-School-Java-Projects\\FileIOTest\\output.txt"));
            String s;
            while((s = br.readLine()) != null)
            {
                bw.write(s + System.getProperty("line.separator"));
            }
            br.close();
            bw.close();
        }
        catch(Exception e)
        {
            return;
        }
    }
}