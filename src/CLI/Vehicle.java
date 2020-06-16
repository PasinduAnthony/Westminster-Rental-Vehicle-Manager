package CLI;

public abstract class Vehicle
{
    protected String PlateNo;
    protected String Make;
    protected int EngineCapacity;
    protected int SeatCapacity;
    protected double price;
    protected int topSpeed;
    protected int FuelCapacity;
    protected static int VehicleCount=0;

    public Vehicle(String PN, String Make, int EngineC, int Seat, double price, int speed, int FuelCapacity)
    {
        this.PlateNo=PN;
        this.Make=Make;
        this.EngineCapacity=EngineC;
        this.SeatCapacity=Seat;
        this.price=price;
        this.topSpeed=speed;
        this.FuelCapacity=FuelCapacity;
        VehicleCount+=1;
    }
    public Vehicle()
    {
        this.PlateNo="";
        this.Make="";
        this.EngineCapacity=0;
        this.SeatCapacity=0;
        this.price=0.0;
        this.topSpeed=0;
        this.FuelCapacity=0;
        VehicleCount+=1;
    }


    public String getPlateNo() {
        return PlateNo;
    }

    public int getNoOfDoor() {
        return getNoOfDoor();
    }

    public boolean isWagon() {
        return isWagon();
    }

    public boolean isAirConditioned() {
        return isAirConditioned();
    }

    public boolean isHasAirBags() {
        return isHasAirBags();
    }

    public int getCarID() {
        return getCarID();
    }

    public String getMake() {
        return Make;
    }

    public int getEngineCapacity() {
        return EngineCapacity;
    }

    public int getSeatCapacity() {
        return SeatCapacity;
    }

    public int getPrice() {
        return (int) price;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public int getFuelCapacity() {
        return FuelCapacity;
    }
    public double calculateRent()
    {
        return 0.0;
    }


    public int getNoOfHelmets() {
        return getNoOfHelmets();
    }

    public int getBikeID() {
        return getBikeID();
    }

    @Override
    public String toString() {
        return " PlateNo = " + PlateNo +
                " Make = " + Make +
                " Engine Capacity = " + EngineCapacity +
                " Seat Capacity = " + SeatCapacity +
                " Price = " + price +
                " Top Speed = " + topSpeed +
                " FuelCapacity = " + FuelCapacity;
    }
}
