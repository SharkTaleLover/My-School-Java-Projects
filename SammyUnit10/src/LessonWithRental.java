public class LessonWithRental extends Rental
{
    boolean isLessonRequired;
    Equipment equipment;
    final String[] instructorNames = {"Josie", "Josh", "James", "Jonathan", "Jacob", "Julia", "Jordyn", "Jade"};

    public LessonWithRental(int eventNum, int rentalMins, Equipment equipmentType)
    {
        super(eventNum, rentalMins, equipmentType);
        isLessonRequired = !equipmentType.equals(Equipment.PERSONAL_WATERCRAFT) && !equipmentType.equals(Equipment.PONTOON_BOAT);
    }

    public String getInstructor()
    {
        return equipment.name() + " lesson required: " + isLessonRequired + ". \nInstructor: " + instructorNames[equipment.ordinal()];
    }
}
