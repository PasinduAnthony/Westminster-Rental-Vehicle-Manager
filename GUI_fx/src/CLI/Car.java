package CLI;

public class Car extends Vehicle {
    private int noofDoors;
    private boolean isWagon;
    private boolean isAirConditioned;
    private int carID;
    private boolean maxCountReacted;

    public Car(String pn, String make, int engineC, int seat, double price, int speed, int fuelCapacity, int noofDoors, Boolean isWagon, Boolean isAirConditioned, int carID){
        super(pn,make,engineC,seat,price,speed,fuelCapacity);
        this.noofDoors=noofDoors;
        this.isWagon=isWagon;
        this.isAirConditioned=isAirConditioned;
        this.carID=carID;
        if(super.getVehicleCount()>50){
            this.maxCountReacted=true;
        }else{
            this.maxCountReacted=false;
        }
    }
    public Car(){
        super();
        this.noofDoors=0;
        this.isWagon=false;
        this.isAirConditioned=false;
        this.carID=0;
        if(super.getVehicleCount()>50){
            this.maxCountReacted=true;
        }else{
            this.maxCountReacted=false;
        }
    }

    public int getNoofDoors() {
        return noofDoors;
    }

    public boolean isWagon() {
        return isWagon;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public int getCarID() {
        return carID;
    }

    public boolean isMaxCountReacted() {
        return maxCountReacted;
    }

    public String getPlateNo(){
        return super.getPlateNo();
    }
    public String getMake(){
        return super.getMake();
    }
    public int getEngineCapacity(){
        return super.getEngineCapacity();
    }
    public int getSeatCapacity(){
        return super.getSeatCapacity();
    }
    public double getPrice(){
        return super.getPrice();
    }
    public int getTopSpeed(){
        return super.getTopSpeed();
    }
    public int getFuelCapacity(){
        return super.getFuelCapacity();
    }


    public void setNoofDoors(int noofDoors) {
        this.noofDoors = noofDoors;
    }

    public void setWagon(boolean wagon) {
        isWagon = wagon;
    }

    public void setAirConditioned(boolean airConditioned) {
        isAirConditioned = airConditioned;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNo='" + super.getPlateNo() + '\'' +
                ", make='" + super.getMake() + '\'' +
                ", engineCapacity=" + super.getEngineCapacity() +
                ", seatCapacity=" + super.getSeatCapacity() +
                ", price=" + super.getPrice() +
                ", topSpeed=" + super.getTopSpeed() +
                ", fuelCapacity=" + super.getFuelCapacity() +
                ", noofDoors=" + noofDoors +
                ", isWagon=" + isWagon +
                ", isAirConditioned=" + isAirConditioned +
                ", carID=" + carID +
                '}';
    }
}
