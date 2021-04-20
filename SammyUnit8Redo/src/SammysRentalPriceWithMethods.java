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
        System.out.print("Enter equipment: 1, 2, 3, 4, 5, 6, 7, 8 >");
        int userEquipmentNum = input.nextInt();
        String userEquipment;
        switch (userEquipmentNum)
        {
            case 1:
                userEquipment = "PERSONAL_WATERCRAFT";
                break;
            case 2:
                userEquipment = "PONTOON_BOAT";
                break;
            case 3:
                userEquipment = "ROWBOAT";
                break;
            case 4:
                userEquipment = "CANOE";
                break;
            case 5:
                userEquipment = "KAYAK";
                break;
            case 6:
                userEquipment = "BEACH_CHAIR";
                break;
            case 7:
                userEquipment = "UMBRELLA";
                break;
            case 8:
                userEquipment = "OTHER";
                break;
            default:
                userEquipment = "OTHER";
                break;
        }

        while (Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.PERSONAL_WATERCRAFT
                && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.PONTOON_BOAT
                && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.ROWBOAT
                && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.CANOE
                && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.KAYAK
                && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.BEACH_CHAIR
                && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.UMBRELLA
                && Rental.Equipment.valueOf(userEquipment) != Rental.Equipment.OTHER)
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