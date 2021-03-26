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
    private Equipment equipment;
    public enum Equipment {KAYAK, SURFBOARD, JETSKI};

    public Rental(int contractNumber, int minutes, Equipment equipmentUsed)
    {
        setContractNumber(String.valueOf(contractNumber));
        setHoursAndMinutes(minutes);
        setEquipment(equipmentUsed);
    }

    public Rental()
    {
        this(000, 0, Equipment.KAYAK);
    }

    public void setContractNumber(String num)
    {
        contractNumber = num;
    }

    public void setEquipment(Equipment equipmentUsed)
    {
        equipment = equipmentUsed;
    }

    public Equipment getEquipment()
    {
        return equipment;
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
            int minutesExtraCost = MINUTE_CAP;
            price = hoursRented * HOUR_RENTAL_COST + minutesExtraCost;
        }
        else
            price = hoursRented * HOUR_RENTAL_COST + minutesExtra;
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
