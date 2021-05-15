import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class RentalDemoAndCreateFile
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int minutesRented, hoursRented, rentalCost, minutesExtra;
      Rental[] rentals = new Rental[8];

      for(int i = 0; i < rentals.length; i++)
      {
         while(true)
         {
            try
            {
               rentals[i] = new Rental(i + 1, SammysRentalPriceWithMethods.askRental(), SammysRentalPriceWithMethods.askEquipment());
               break;
            } catch (InputMismatchException e)
            {
               System.out.println("Please enter in the correct format.");
            }
         }
      }

      SammysRentalPriceWithMethods.displayMotto();
      System.out.println();

        /*

        for(int i = 0; i < person3.getHoursRented(); i++)
        {
            System.out.println("Coupon good for 10% off next rental");
        }

         */

      System.out.println();

      for (Rental rental : rentals)
      {
         SammysRentalPriceWithMethods.displayRental(rental);
      }

      while(true)
      {
         System.out.print("Would you like to sort ascending order by (C)ontract price, (#)Contract Number, or (E)quipment Type, or (Q)uit >");
         char userChoice = input.next().charAt(0);

         if (userChoice == 'Q')
            break;

         while (userChoice != 'C' && userChoice != '#' && userChoice != 'E') {
            System.out.print("Please enter again >");
            userChoice = input.next().charAt(0);
         }

         SammysRentalPriceWithMethods.sortRentals(rentals, userChoice);

         for (Rental rental : rentals)
         {
            SammysRentalPriceWithMethods.displayRental(rental);
         }
      }

      SammysRentalPriceWithMethods.sortRentals(rentals, '#');
      try
      {
         Path rentalsFile = Paths.get("Rentals.txt");
         rentalsFile.toFile().createNewFile();
         OutputStream out = new BufferedOutputStream(Files.newOutputStream(rentalsFile, CREATE));
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
         String s = "";
         String delimiter = ",";

         for(int i = 0; i < rentals.length; i++)
         {
            s = rentals[i].getContractNumber() + delimiter + rentals[i].getEquipment().getEquipmentName() + delimiter + (rentals[i].getHoursRented()*60+rentals[i].getMinutesExtra()) + delimiter + rentals[i].getPrice() + System.getProperty("line.separator");
            writer.write(s);
         }
         writer.close();
      }
      catch (Exception e)
      {
         System.out.println("Error: " + e);
      }
      DisplayRentalFile.displayFile();

        /*

        SammysRentalPriceWithMethods.displayRental(compareRentals(person1, person2));
        System.out.println();
        SammysRentalPriceWithMethods.displayRental(compareRentals(person1, person3));
        System.out.println();
        SammysRentalPriceWithMethods.displayRental(compareRentals(person2, person3));

         */
   }

    /*

    public static Rental compareRentals(Rental r1, Rental r2)
    {
        SammysRentalPriceWithMethods.displayRental(r1);
        SammysRentalPriceWithMethods.displayRental(r2);

        if(r1.getHoursRented() * 60 + r1.getMinutesExtra() > r2.getHoursRented() * 60 + r2.getMinutesExtra())
            return r1;
        else if(r1.getHoursRented() * 60 + r1.getMinutesExtra() < r2.getHoursRented() * 60 + r2.getMinutesExtra())
            return r2;
        else
            return r1;
    }

     */
}
