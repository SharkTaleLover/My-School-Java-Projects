public abstract class Equipment {
    Rental.EquipmentType equipmentType;
    String equipmentName;
    double equipmentFee;
    public static final String[] equipmentNames = {"personal watercraft", "pontoon boat", "rowboar", "canoe", "kayak", "beach chair", "umbrella", "other"};
    public static final double[] surcharges = {50, 40, 15, 12, 10, 2, 1, 0};

    public Equipment(Rental.EquipmentType equipType)
    {
        equipmentType = equipType;
    }

    public Rental.EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Rental.EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public double getEquipmentFee() {
        return equipmentFee;
    }

    public void setEquipmentFee(double equipmentFee) {
        this.equipmentFee = equipmentFee;
    }

    public abstract String getPolicy();
}
