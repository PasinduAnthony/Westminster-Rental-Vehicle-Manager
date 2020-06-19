package CLI;

public abstract class Vehicle {
    private String plateNo;
    private String make;
    private int engineCapacity;
    private int seatCapacity;
    private double price;
    private int topSpeed;
    private int fuelCapacity;
    private static int vehicleCount=0;

    public Vehicle(String pn, String make, int engineC, int seat, double price, int speed, int fuelCapacity)
    {
        this.plateNo=pn;
        this.make=make;
        this.engineCapacity=engineC;
        this.seatCapacity=seat;
        this.price=price;
        this.topSpeed=speed;
        this.fuelCapacity=fuelCapacity;
        this.vehicleCount+=1;

    }

    public Vehicle()
    {
        this.plateNo="";
        this.make="";
        this.engineCapacity=0;
        this.seatCapacity=0;
        this.price=0.0;
        this.topSpeed=0;
        this.fuelCapacity=0;
        this.vehicleCount+=1;

    }

    public String getPlateNo(){
        return plateNo;
    }
    public String getMake(){
        return make;
    }
    public int getEngineCapacity(){
        return engineCapacity;
    }
    public int getSeatCapacity(){
        return seatCapacity;
    }
    public double getPrice(){
        return price;
    }
    public int getTopSpeed(){
        return topSpeed;
    }
    public int getFuelCapacity(){
        return fuelCapacity;
    }
    public static int getVehicleCount() {
        return vehicleCount;
    }


    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public static void setVehicleCount(int vehicleCount) {
        Vehicle.vehicleCount = vehicleCount;
    }

    public int getNoOfHelmets() {
        return getNoOfHelmets();
    }

    public int getBikeID() {
        return getBikeID();
    }

    public int getNoofDoors() {
        return getNoofDoors();
    }

    public boolean isWagon() {
        return isWagon();
    }

    public boolean isAirConditioned() {
        return isAirConditioned();
    }

    public int getCarID() {
        return getCarID();
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNo='" + plateNo + '\'' +
                ", make='" + make + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", seatCapacity=" + seatCapacity +
                ", price=" + price +
                ", topSpeed=" + topSpeed +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }
}
