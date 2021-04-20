public class LessonWithRental extends Rental
{
    boolean isLessonRequired;
    EquipmentType equipmentType;
    final String[] instructorNames = {"Josie", "Josh", "James", "Jonathan", "Jacob", "Julia", "Jordyn", "Jade"};

    public LessonWithRental(int eventNum, int rentalMins, EquipmentType equipmentType)
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
            case ROWBOAT:
                isLessonRequired = true;
                break;
            case CANOE:
                isLessonRequired = true;
                break;
            case KAYAK:
                isLessonRequired = true;
                break;
            default:
                isLessonRequired = false;
                break;
        }
    }

    public String getInstructor()
    {
        return equipmentType.name() + " lesson required: " + isLessonRequired + ". \nInstructor: " + instructorNames[equipmentType.ordinal()];
    }
}