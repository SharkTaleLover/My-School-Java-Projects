public class LessonWithRental extends Rental
{
    boolean isLessonRequired;
    Equipment equipment;
    final String[] instructorNames = {"Josie", "Josh", "James", "Jonathan", "Jacob", "Julia", "Jordyn", "Jade"};

    public LessonWithRental(int eventNum, int rentalMins, Equipment equipmentType)
    {
        super(eventNum, rentalMins, equipmentType);
        switch (equipmentType)
        {
            case PERSONAL_WATERCRAFT:
                isLessonRequired = true;
                break;
            case PONTOON_BOAT:
                isLessonRequired = true;
                break;
            default:
                isLessonRequired = false;
                break;
        }
    }

    public String getInstructor()
    {
        return equipment.name() + " lesson required: " + isLessonRequired + ". \nInstructor: " + instructorNames[equipment.ordinal()];
    }
}