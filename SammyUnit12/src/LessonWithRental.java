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
            case PERSONAL_WATERCRAFT, PONTOON_BOAT, ROWBOAT, CANOE, KAYAK -> isLessonRequired = true;
            default -> isLessonRequired = false;
        }
    }

    public String getInstructor()
    {
        return equipmentType.name() + " lesson required: " + isLessonRequired + ". \nInstructor: " + instructorNames[equipmentType.ordinal()];
    }
}