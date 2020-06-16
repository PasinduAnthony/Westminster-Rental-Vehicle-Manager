package CLI;

public interface RentalvehicleManager
{
    public abstract void addVehicle(Vehicle vehicle);
    public abstract void deleteVehicle(String plateNo);
    public abstract void viewVehicle();
    void Starting();
}
