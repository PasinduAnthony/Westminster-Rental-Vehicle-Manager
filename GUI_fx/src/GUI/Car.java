package GUI;
public class Car
{
    public String PlateNo;
    public String Make;
    public int EngineCapacity;
    public double price;
    public int topSpeed;
    public int FuelCapacity;
    public int SeatCapacity;
    protected int NoOfDoor;
    protected boolean isWagon;
    protected boolean isAirConditioned;
    protected boolean hasAirBags;
    protected int CarID;

    public Car(String PN, String Make, int EngineC, int Seat, double price, int speed, int FuelCapacity, int NumDoors, boolean wagon, boolean AirCondition, boolean Airbags, int CarID)
    {
        this.PlateNo=PN;
        this.Make=Make;
        this.EngineCapacity=EngineC;
        this.price=price;
        this.topSpeed=speed;
        this.FuelCapacity=FuelCapacity;
        this.SeatCapacity=Seat;
        this.NoOfDoor=NumDoors;
        this.isWagon=wagon;
        this.isAirConditioned=AirCondition;
        this.hasAirBags=Airbags;
        this.CarID=CarID;

    }
    public Car()
    {
        this.PlateNo="";
        this.Make="";
        this.EngineCapacity=0;
        this.price=0.0;
        this.topSpeed=0;
        this.FuelCapacity=0;
        this.SeatCapacity=0;
        this.NoOfDoor=0;
        this.isWagon=false;
        this.isAirConditioned=false;
        this.hasAirBags=false;
        this.CarID=0;
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

    public int getNoOfDoor() {
        return NoOfDoor;
    }

    public boolean isWagon() {
        return isWagon;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public boolean isHasAirBags() {
        return hasAirBags;
    }

    public int getCarID() {
        return CarID;
    }

    @Override
    public String toString() {
        return "Car-------------------------\n" +
                " NoOfDoor = " + NoOfDoor +
                " Is Wagon = " + isWagon +
                " Is AirConditioned = " + isAirConditioned +
                " Has AirBags = " + hasAirBags +
                " Car ID = " + CarID
                +"\n----------------------------";
    }


}
