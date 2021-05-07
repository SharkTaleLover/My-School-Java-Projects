public class Rental
{
   private static final int HOUR_RENTAL_COST = 40;
   private static final int MINUTES_IN_HOUR = 60;
   private static final int MINUTE_CAP = 40;
   private String contractNumber;
   private String phoneNumber;
   private int hoursRented;
   private int minutesExtra;
   private double price;
   Equipment equipment;
   double basePrice;
   public enum EquipmentType {PERSONAL_WATERCRAFT, PONTOON_BOAT, ROWBOAT, CANOE, KAYAK,
      BEACH_CHAIR, UMBRELLA, OTHER}

   public Rental(int contractNumber, int minutes, EquipmentType equipmentTypeUsed)
   {
      setContractNumber(String.valueOf(contractNumber));
      setHoursAndMinutes(minutes);
      switch (equipmentTypeUsed)
      {
         case BEACH_CHAIR, UMBRELLA, OTHER -> equipment = new EquipmentWithoutLesson(equipmentTypeUsed);
         default -> equipment = new EquipmentWithLesson(equipmentTypeUsed);
      }
      price = equipment.getEquipmentFee() + basePrice;
   }

   public Rental()
   {
      this(0, 0, EquipmentType.PERSONAL_WATERCRAFT);
   }

   public void setContractNumber(String num)
   {
      contractNumber = num;
   }

   public Equipment getEquipment() {
      return equipment;
   }

   public void setEquipment(Equipment equipment) {
      this.equipment = equipment;
   }

   public String getContractNumber()
   {
      return contractNumber;
   }

   public void setHoursAndMinutes(int minutes) {
      hoursRented = minutes / MINUTES_IN_HOUR;
      minutesExtra = minutes % MINUTES_IN_HOUR;
      if(minutesExtra > MINUTE_CAP)
      {
         basePrice = hoursRented * HOUR_RENTAL_COST + MINUTE_CAP;
      }
      else
         basePrice = hoursRented * HOUR_RENTAL_COST + minutesExtra;
   }

   public int getHoursRented()
   {
      return hoursRented;
   }

   public int getMinutesExtra()
   {
      return minutesExtra;
   }

   public double getPrice()
   {
      return price;
   }
}
