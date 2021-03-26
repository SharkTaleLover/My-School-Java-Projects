import java.util.Scanner;

public class RentalDemo
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int minutesRented, hoursRented, rentalCost, minutesExtra;
        Rental[] rentals = new Rental[8];

        for(int i = 0; i < rentals.length; i++)
        {
            rentals[i] = new Rental(i + 1, SammysRentalPriceWithMethods.askRental(), SammysRentalPriceWithMethods.askEquipment());
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

        for(int i = 0; i < rentals.length; i++)
        {
            SammysRentalPriceWithMethods.displayRental(rentals[i]);
        }

        System.out.print("Would you like to sort ascending order by (C)ontract price, (#)Contract Number, or (E)quipment Type >");
        char userChoice = input.next().charAt(0);

        while(userChoice != 'C' && userChoice != '#' && userChoice != 'E')
        {
            System.out.print("Please enter again >");
            userChoice = input.next().charAt(0);
        }

        SammysRentalPriceWithMethods.sortRentals(rentals, userChoice);

        for(int i = 0; i < rentals.length; i++)
        {
            SammysRentalPriceWithMethods.displayRental(rentals[i]);
        }

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
