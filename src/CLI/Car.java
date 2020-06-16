package CLI;

public class Car extends Vehicle
{
    protected int NoOfDoor;
    protected boolean isWagon;
    protected boolean isAirConditioned;
    protected boolean hasAirBags;
    protected int CarID;

    public Car(String PN, String Make, int EngineC, int Seat, double price, int speed, int FuelCapacity, int NumDoors, boolean wagon, boolean AirCondition, boolean Airbags, int CarID)
    {
        super(PN,Make,EngineC,Seat,price,speed,FuelCapacity);
        this.NoOfDoor=NumDoors;
        this.isWagon=wagon;
        this.isAirConditioned=AirCondition;
        this.hasAirBags=Airbags;
        this.CarID=CarID;

    }
    public Car()
    {
        super();
        this.NoOfDoor=0;
        this.isWagon=false;
        this.isAirConditioned=false;
        this.hasAirBags=false;
        this.CarID=0;
    }

    @Override
    public int getNoOfDoor() {
        return NoOfDoor;
    }
    @Override
    public boolean isWagon() {
        return isWagon;
    }
    @Override
    public boolean isAirConditioned() {
        return isAirConditioned;
    }
    @Override
    public boolean isHasAirBags() {

        return hasAirBags;
    }
    @Override
    public int getCarID() {
        return CarID;
    }

    @Override
    public String getMake() {
        return super.getMake();
    }





    @Override
    public String toString() {
        return "Car-------------------------\n" +
                 super.toString()+
                " NoOfDoor = " + NoOfDoor +
                " Is Wagon = " + isWagon +
                " Is AirConditioned = " + isAirConditioned +
                " Has AirBags = " + hasAirBags +
                " Car ID = " + CarID
                +"\n----------------------------";
    }


}
