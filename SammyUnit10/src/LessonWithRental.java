public class LessonWithRental extends Rental
{
    boolean isLessonRequired;
    Equipment equipment;
    final String[] instructorNames = {"Josie", "Josh", "James", "Jonathan", "Jacob", "Julia", "Jordyn", "Jade"};

    public LessonWithRental(int eventNum, int rentalMins, Equipment equipmentType)
    {
        super(eventNum, rentalMins, equipmentType);
        if(equipmentType.equals(Equipment.KAYAK))
            isLessonRequired = false;
        else
            isLessonRequired = true;
    }

    public String getInstructor()
    {
        return equipment.name() + " lesson required: " + isLessonRequired + ". \nInstructor: " + instructorNames[equipment.ordinal()];
    }
}
