package CLI;

public class MotorBike extends Vehicle {
    private int noOfHelmets;
    private int bikeID;
    private boolean maxCountReacted;

    public MotorBike(String pn, String make, int engineC, int seat, double price, int speed, int fuelCapacity, int noOfHelmets, int bikeID){
        super(pn,make,engineC,seat,price,speed,fuelCapacity);
        this.noOfHelmets=noOfHelmets;
        this.bikeID=bikeID;
        if(super.getVehicleCount()>50){
            this.maxCountReacted=true;
        }else{
            this.maxCountReacted=false;
        }
    }
    public MotorBike(){
        super();
        this.noOfHelmets=0;
        this.bikeID=0;
        if(super.getVehicleCount()>50){
            this.maxCountReacted=true;
        }else{
            this.maxCountReacted=false;
        }
    }

    public int getNoOfHelmets() {
        return noOfHelmets;
    }

    public int getBikeID() {
        return bikeID;
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

    public void setNoOfHelmets(int noOfHelmets) {
        this.noOfHelmets = noOfHelmets;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }



    @Override
    public String toString() {
        return "MotorBike{" +
                "plateNo='" + super.getPlateNo() + '\'' +
                ", make='" + super.getMake() + '\'' +
                ", engineCapacity=" + super.getEngineCapacity() +
                ", seatCapacity=" + super.getSeatCapacity() +
                ", price=" + super.getPrice() +
                ", topSpeed=" + super.getTopSpeed() +
                ", fuelCapacity=" + super.getFuelCapacity() +
                ", no of Helmets=" + noOfHelmets +
                ", Bike ID=" + bikeID +
                '}';
    }
}
