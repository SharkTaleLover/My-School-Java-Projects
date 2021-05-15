public class EquipmentWithoutLesson extends Equipment {

    public EquipmentWithoutLesson(Rental.EquipmentType equipmentType)
    {
        super(equipmentType);
        equipmentName = equipmentNames[equipmentType.ordinal()];
        equipmentFee = surcharges[equipmentType.ordinal()];
    }

    public String getPolicy() {
        return null;
    }
}
