package CLI;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class WestminsterRentalVehicleManager implements RentalvehicleManager
{
    protected String VehicleNumber;
    protected String vehicleType;
    protected String CustomerName;
    private int count=0;
    public static ArrayList<Vehicle> vehicleList= new ArrayList<Vehicle>();



    public WestminsterRentalVehicleManager(String VT, String VN, String CN)
    {
        this.vehicleType=VT;
        this.VehicleNumber=VN;
        this.CustomerName=CN;
    }

    public WestminsterRentalVehicleManager()
    {
        this.vehicleType="";
        this.VehicleNumber="";
        this.CustomerName="";
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if(count<51){
            vehicleList.add(vehicle);
            count+=count;
        }else if (count==51){
            System.out.println("Maximum Number of Vehicles reached");
        }
    }

    @Override
    public void viewVehicle(){
        String pno=null;
        if(vehicleType.equals("car")){
            for (int i = 0; i < vehicleList.size(); i++) {
                pno = vehicleList.get(i).PlateNo;
                if(pno.substring(0,1).equals("P")){
                    System.out.println(vehicleList.get(i));
                }
            }
        }else if(vehicleType.equals("bike")){
            for (int i = 0; i < vehicleList.size(); i++) {
                pno = vehicleList.get(i).PlateNo;
                if(pno.substring(0,1).equals("B")){
                    System.out.println(vehicleList.get(i));
                }
            }
        }else if(vehicleType.equals("all")){
            for (int i = 0; i < vehicleList.size(); i++) {
                    System.out.println(vehicleList.get(i));

            }
        }

    }

    @Override
    public void deleteVehicle(String plateNO) {
        System.out.println(plateNO);
        int count=0;
        for (int i = 0; i < vehicleList.size(); i++) {

            if (plateNO.equals(vehicleList.get(i).getPlateNo())){
                vehicleList.remove(i);
            }
        }
    }

    public void Finalizing()
    {
        DeletingCardb();
        DeletingBikedb();
        AddingTodb();
        AddingTotext();
    }



    @Override
    public void Starting(){
        TextReadCar();
        TextReaderBike();
    }

    private void TextReaderBike() {
        try{
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);

            String query3 = "SELECT * FROM motorbike ORDER BY Make ASC ";
            // create the java statement
            Statement st3 = cont.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs3 = st3.executeQuery(query3);

            while (rs3.next()) {
                MotorBike newBike = new MotorBike();
                newBike.PlateNo = rs3.getString("PlateNo");
                newBike.Make = rs3.getString("Make");
                newBike.EngineCapacity = rs3.getInt("EngineCapacity");
                newBike.price = rs3.getLong("Price");
                newBike.topSpeed = rs3.getInt("TopSpeed");
                newBike.FuelCapacity = rs3.getInt("FuelCapacity");
                newBike.SeatCapacity = rs3.getInt("SeatCapacity");
                newBike.BikeID = rs3.getInt("bikeID");
                newBike.noOfHelmets = rs3.getInt("noofHelmets");
                vehicleList.add(newBike);
            }
            System.out.println("Motorbike Table was successfully added from the database");
            st3.close();

        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    private void TextReadCar(){
        try{
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query2 = "SELECT * FROM car ORDER BY Make ASC ";
            // create the java statement
            Statement st2 = cont.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs2 = st2.executeQuery(query2);

            while(rs2.next()){
                Car carRead = new Car();
                carRead.PlateNo = rs2.getString("PlateNo");
                carRead.Make = rs2.getString("Make");
                carRead.EngineCapacity = rs2.getInt("EngineCapacity");
                carRead.price = rs2.getLong("Price");
                carRead.topSpeed = rs2.getInt("TopSpeed");
                carRead.FuelCapacity = rs2.getInt("FuelCapacity");
                carRead.SeatCapacity = rs2.getInt("SeatCapacity");
                carRead.NoOfDoor = rs2.getInt("noOFDoors");
                carRead.isWagon = rs2.getBoolean("isWagon");
                carRead.isAirConditioned = rs2.getBoolean("isAirConditioned");
                carRead.hasAirBags = rs2.getBoolean("hasAirbags");
                carRead.CarID = rs2.getInt("carID");
                vehicleList.add(carRead);
            }
            st2.close();
            System.out.println("Car Table was successfully added from the database");
            }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

    }

    private void DeletingCardb(){
        try{
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query2 = "DELETE FROM car";
            Statement stmt = cont.createStatement();
            stmt.executeUpdate(query2);
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    private void DeletingBikedb(){
        try{
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query2 = "DELETE FROM motorbike";
            Statement stmt = cont.createStatement();
            stmt.executeUpdate(query2);
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void AddingTodb() {
        try {
            //Car car = new Car();
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            int wagon;
            int ac;
            int airbags;
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);
            //inserting data to the Car table in DB
            String check;
            for (int i = 0; i < vehicleList.size(); i++) {
                check = vehicleList.get(i).getPlateNo();
                if(check.substring(0,1).equals("P")) {
                    String contquery2 = "INSERT INTO car (PlateNo,Make,EngineCapacity,SeatCapacity, Price, TopSpeed, FuelCapacity,noOFDoors,isWagon,isAirConditioned,hasAirbags,carID)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement contpst2 = cont.prepareStatement(contquery2);
                    contpst2.setString(1, vehicleList.get(i).getPlateNo());
                    contpst2.setString(2, vehicleList.get(i).getMake());
                    contpst2.setString(3, String.valueOf(vehicleList.get(i).getEngineCapacity()));
                    contpst2.setString(4, String.valueOf(vehicleList.get(i).getSeatCapacity()));
                    contpst2.setString(5, String.valueOf(vehicleList.get(i).getPrice()));
                    contpst2.setString(6, String.valueOf(vehicleList.get(i).getTopSpeed()));
                    contpst2.setString(7, String.valueOf(vehicleList.get(i).getFuelCapacity()));
                    contpst2.setString(8, String.valueOf(vehicleList.get(i).getNoOfDoor()));
                    if (vehicleList.get(i).isWagon()== true) {
                        wagon = 1;
                    } else {
                        wagon = 0;
                    }
                    if (vehicleList.get(i).isAirConditioned() == true) {
                        ac = 1;
                    } else {
                        ac = 0;
                    }
                    if (vehicleList.get(i).isHasAirBags()==true) {
                        airbags = 1;
                    } else {
                        airbags = 0;
                    }
                    contpst2.setString(9, String.valueOf(wagon));
                    contpst2.setString(10, String.valueOf(ac));
                    contpst2.setString(11, String.valueOf(airbags));
                    contpst2.setString(12, String.valueOf(vehicleList.get(i).getCarID()));
                    contpst2.executeUpdate();
                }else if(check.substring(0,1).equals("B")) {
                    String contquery = "INSERT INTO motorbike (PlateNo,Make,EngineCapacity,SeatCapacity, Price, TopSpeed, FuelCapacity,noofHelmets,bikeID)VALUES(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement contpst = cont.prepareStatement(contquery);
                    contpst.setString(1, vehicleList.get(i).getPlateNo());
                    contpst.setString(2, vehicleList.get(i).getMake());
                    contpst.setString(3, String.valueOf(vehicleList.get(i).getEngineCapacity()));
                    contpst.setString(4, String.valueOf(vehicleList.get(i).getSeatCapacity()));
                    contpst.setString(5, String.valueOf(vehicleList.get(i).getPrice()));
                    contpst.setString(6, String.valueOf(vehicleList.get(i).getTopSpeed()));
                    contpst.setString(7, String.valueOf(vehicleList.get(i).getFuelCapacity()));
                    contpst.setString(8, String.valueOf(vehicleList.get(i).getNoOfHelmets()));
                    contpst.setString(9, String.valueOf(vehicleList.get(i).getBikeID()));
                    contpst.executeUpdate();
                }
                }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    private void AddingTotext() {
        try{
            FileWriter myWriter = new FileWriter("data.txt");
            for (int i = 0; i < vehicleList.size(); i++) {
                myWriter.write(vehicleList.get(i).toString()+"\n");
            }
            myWriter.close();
        }catch (IOException e){
            System.out.println("An Error occured in textFile");
            e.printStackTrace();
        }

    }

    }
