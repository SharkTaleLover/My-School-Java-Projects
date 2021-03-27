import java.util.Scanner;
public class SammysRentalPriceWithMethods
{
    public static int minutesRented, hoursRented, rentalCost, minutesExtra;

    public static void main(String[] args)
    {
        askRental();
        displayMotto();
    }

    public static int askRental() {
        Scanner input = new Scanner(System.in);
        int minutesRented = 0;
        while(minutesRented < 60 || minutesRented > 7200)
        {
            System.out.print("Enter minutes rented between 60 and 7200 >");
            minutesRented = input.nextInt();
        }
        return minutesRented;
    }

    public static Rental.Equipment askEquipment()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter equipment (Kayak, Surfboard, or Jetski >");
        String userEquipment = input.next().toUpperCase();

        while (Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.KAYAK && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.SURFBOARD && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.JETSKI)
        {
            System.out.print("Please reenter your equipment >");
            userEquipment = input.next().toUpperCase();
        }

        return Rental.Equipment.valueOf(userEquipment);
    }

    public static void displayMotto() {
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        System.out.println("S  Sammy’s makes it fun in the sun.  S");
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }

    public static void displayRental(Rental obj) {
        System.out.println("Contract #"+obj.getContractNumber()+" You rented "+obj.getEquipment().toString()+" for "+obj.getHoursRented()+" hours and "+obj.getMinutesExtra()+" minutes for a total of $"+obj.getPrice());
    }

    public static void sortRentals(Rental[] rentals, char order)
    {
        Rental temp;
        for(int i = 0; i < rentals.length - 1; i++)
        {
            for(int j = 0; j < rentals.length - 1 - i; i++)
            {
                if(order == 'C')
                {
                    if (rentals[j].getPrice() > rentals[j + 1].getPrice())
                    {
                        temp = rentals[j];
                        rentals[j] = rentals[j + 1];
                        rentals[j + 1] = temp;
                    }
                }
                else if(order == '#')
                {
                    if (Integer.parseInt(rentals[j].getContractNumber()) > Integer.parseInt(rentals[j + 1].getContractNumber()))
                    {
                        temp = rentals[j];
                        rentals[j] = rentals[j + 1];
                        rentals[j + 1] = temp;
                    }
                }
                else if(order == 'E')
                {
                    if (rentals[j].getEquipment().toString().compareTo(rentals[j + 1].getEquipment().toString()) > 0)
                    {
                        temp = rentals[j];
                        rentals[j] = rentals[j + 1];
                        rentals[j + 1] = temp;
                    }
                }
            }
        }
    }
}