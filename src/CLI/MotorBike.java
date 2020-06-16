package CLI;

public class MotorBike extends Vehicle
{
    protected int noOfHelmets;
    protected int BikeID;

    public MotorBike(String PN, String Make, int EngineC, int Seat, double price, int speed, int FuelCapacity, int helmets, int BikeID)
    {
        super(PN,Make,EngineC,Seat,price,speed,FuelCapacity);
        this.noOfHelmets=helmets;
        this.BikeID=BikeID;
    }
    public MotorBike()
    {
        super();
        this.noOfHelmets=0;
        this.BikeID=0;
    }

    @Override
    public int getNoOfHelmets() {
        return noOfHelmets;
    }

    @Override
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
