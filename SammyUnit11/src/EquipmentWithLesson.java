public class EquipmentWithLesson extends Equipment {

    public EquipmentWithLesson(Rental.EquipmentType equipmentType)
    {
        super(equipmentType);
        equipmentName = equipmentNames[equipmentType.ordinal()];
        equipmentFee = surcharges[equipmentType.ordinal()];
    }

    public String getPolicy()
    {
        return null;
    }
}
