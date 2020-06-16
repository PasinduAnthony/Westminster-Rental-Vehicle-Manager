package CLI;

import java.util.Date;

public class Shedule
{
    protected Date pickupDate;
    protected Date dropOffDate;
    protected Vehicle Vehicle;

    public Shedule(Date pickDate, Date dropDate, Vehicle Vehicle)
    {
        this.pickupDate=pickDate;
        this.dropOffDate=dropDate;
        this.Vehicle=Vehicle;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public int getNoOfDays()
    {
        return 0;
    }
}
