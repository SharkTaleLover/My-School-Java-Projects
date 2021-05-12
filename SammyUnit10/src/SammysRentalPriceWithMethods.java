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
        System.out.print("Enter equipment 1, 2, 3, 4, 5, 6, 7, or 8 >");
        int userEquipmentNum = input.nextInt();
        Rental.Equipment userEquipment;

        switch (userEquipmentNum)
        {
            case 1:
                userEquipment = Rental.Equipment.PERSONAL_WATERCRAFT;
                break;
            case 2:
                userEquipment = Rental.Equipment.PONTOON_BOAT;
                break;
            case 3:
                userEquipment = Rental.Equipment.ROWBOAT;
                break;
            case 4:
                userEquipment = Rental.Equipment.CANOE;
                break;
            case 5:
                userEquipment = Rental.Equipment.KAYAK;
                break;
            case 6:
                userEquipment = Rental.Equipment.BEACH_CHAIR;
                break;
            case 7:
                userEquipment = Rental.Equipment.UMBRELLA;
                break;
            default:
                userEquipment = Rental.Equipment.OTHER;
                break;
        }

        return userEquipment;
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