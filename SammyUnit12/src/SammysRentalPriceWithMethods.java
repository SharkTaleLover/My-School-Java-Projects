import java.util.InputMismatchException;
import java.util.Scanner;

public class SammysRentalPriceWithMethods
{
    public static int minutesRented, hoursRented, rentalCost, minutesExtra;

    /*
    public static void main(String[] args)
    {
        askRental();
        displayMotto();
    }
    */

    public static int askRental() throws InputMismatchException
    {
        Scanner input = new Scanner(System.in);
        int minutesRented = 0;
        while(minutesRented < 60 || minutesRented > 7200)
        {
            System.out.print("Enter minutes rented between 60 and 7200 >");
            minutesRented = input.nextInt();
        }
        return minutesRented;
    }

    public static Rental.EquipmentType askEquipment() throws InputMismatchException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter equipment: 1, 2, 3, 4, 5, 6, 7, 8 >");
        int userEquipmentNum = input.nextInt();
        String userEquipment = switch (userEquipmentNum)
                {
                    case 1 -> "PERSONAL_WATERCRAFT";
                    case 2 -> "PONTOON_BOAT";
                    case 3 -> "ROWBOAT";
                    case 4 -> "CANOE";
                    case 5 -> "KAYAK";
                    case 6 -> "BEACH_CHAIR";
                    case 7 -> "UMBRELLA";
                    default -> "OTHER";
                };

        while (Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.PERSONAL_WATERCRAFT
                && Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.PONTOON_BOAT
                && Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.ROWBOAT
                && Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.CANOE
                && Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.KAYAK
                && Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.BEACH_CHAIR
                && Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.UMBRELLA
                && Rental.EquipmentType.valueOf(userEquipment) != Rental.EquipmentType.OTHER)
        {
            System.out.print("Please reenter your equipment >");
            userEquipment = input.next().toUpperCase();
        }

        return Rental.EquipmentType.valueOf(userEquipment);
    }

    public static void displayMotto() {
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        System.out.println("S  Sammy’s makes it fun in the sun.  S");
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    }

    public static void displayRental(Rental obj) {
        System.out.println("Contract #"+obj.getContractNumber()+" You rented "+obj.getEquipment().getEquipmentName()+" for "+obj.getHoursRented()+" hours and "+obj.getMinutesExtra()+" minutes for a total of $"+obj.getPrice());
    }

    public static void sortRentals(Rental[] rentals, char order)
    {
        Rental temp;
        for(int i = 0; i < rentals.length - 1; i++)
        {
            for(int j = 0; j < rentals.length - 1 - i; j++)
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
                    if (rentals[j].getEquipment().getEquipmentName().compareTo(rentals[j + 1].getEquipment().getEquipmentName()) > 0)
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