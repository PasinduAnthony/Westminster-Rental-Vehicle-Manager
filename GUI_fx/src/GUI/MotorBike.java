package GUI;

public class MotorBike
{
    public String PlateNo;
    public String Make;
    public int EngineCapacity;
    public double price;
    public int topSpeed;
    public int FuelCapacity;
    public int SeatCapacity;
    protected int noOfHelmets;
    protected int BikeID;

    public MotorBike(String PN, String Make, int EngineC, int Seat, double price, int speed, int FuelCapacity, int helmets, int BikeID)
    {
        this.PlateNo=PN;
        this.Make=Make;
        this.EngineCapacity=EngineC;
        this.price=price;
        this.topSpeed=speed;
        this.FuelCapacity=FuelCapacity;
        this.SeatCapacity=Seat;
        this.noOfHelmets=helmets;
        this.BikeID=BikeID;
    }
    public MotorBike()
    {
        this.PlateNo="";
        this.Make="";
        this.EngineCapacity=0;
        this.price=0.0;
        this.topSpeed=0;
        this.FuelCapacity=0;
        this.SeatCapacity=0;
        this.noOfHelmets=0;
        this.BikeID=0;
    }

    public String getPlateNo() {
        return PlateNo;
    }

    public String getMake() {
        return Make;
    }

    public int getEngineCapacity() {
        return EngineCapacity;
    }

    public double getPrice() {
        return price;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getFuelCapacity() {
        return FuelCapacity;
    }

    public int getSeatCapacity() {
        return SeatCapacity;
    }

    public int getNoOfHelmets() {
        return noOfHelmets;
    }

    public int getBikeID() {
        return BikeID;
    }

    @Override
    public String toString() {
        return "MotorBike----------------------\n"
                + super.toString()+" no Of Helmets =" + noOfHelmets +
                " Bike ID =" + BikeID +
                "\n-----------------------------" ;
    }
}
