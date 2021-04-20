import java.util.Scanner;

public class LessonWithRentalDemo
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int minutesRented, hoursRented, rentalCost, minutesExtra;
        LessonWithRental[] lessonRentals = new LessonWithRental[4];

        for(int i = 0; i < lessonRentals.length; i++)
        {
            lessonRentals[i] = new LessonWithRental(i + 1, SammysRentalPriceWithMethods.askRental(), SammysRentalPriceWithMethods.askEquipment());
        }

        SammysRentalPriceWithMethods.displayMotto();
        System.out.println();

        for(int i = 0; i < lessonRentals.length; i++)
        {
            SammysRentalPriceWithMethods.displayRental(lessonRentals[i]);
        }

        while(1 == 1) {
            System.out.print("Would you like to sort ascending order by (C)ontract price, (#)Contract Number, or (E)quipment Type, or (Q)uit >");
            char userChoice = input.next().charAt(0);

            if (userChoice == 'Q')
                System.exit(0);

            while (userChoice != 'C' && userChoice != '#' && userChoice != 'E') {
                System.out.print("Please enter again >");
                userChoice = input.next().charAt(0);
            }

            SammysRentalPriceWithMethods.sortRentals(lessonRentals, userChoice);

            for (int i = 0; i < lessonRentals.length; i++) {
                SammysRentalPriceWithMethods.displayRental(lessonRentals[i]);
            }
        }
    }
}
