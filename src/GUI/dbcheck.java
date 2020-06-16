package GUI;
import java.sql.*;
import java.util.ArrayList;

public class dbcheck
{
    private static ArrayList<String> Cars = new ArrayList<String>();
    private static ArrayList<String> Bikes = new ArrayList<String>();
    private static ArrayList<String> SheduleCar = new ArrayList<String>();
    private static ArrayList<String> SheduleBike = new ArrayList<String>();
    private static ArrayList<String> cusName = new ArrayList<>();
    private static ArrayList<String> cuspass = new ArrayList<>();

    public Boolean Checkdate(String input){
        //to check if it exsist in db car and motorbike
        Boolean consist = false;
        Shedule();
        CarCheck();
        System.out.println(input);
        for (int i = 0; i < SheduleCar.size(); i++) {
            if(SheduleCar.get(i).equals(input)){
                consist=true;
            }
        }
        BikeCheck();
        for (int j = 0; j < SheduleBike.size(); j++) {
            if(SheduleBike.get(j).equals(input)){
                consist = true;
            }
        }
        return consist;
    }

    public Boolean Login(String input1, String input2){
        CustomerCheck();
        Boolean idconsist = false;
        Boolean passconsist = false;
        Boolean consist = false;
        for (int i = 0; i < cusName.size(); i++) {
            if(cusName.get(i).equals(input1)){
                idconsist=true;
            }
        }
        for (int j = 0; j < cuspass.size(); j++) {
            if(cuspass.get(j).equals(input2)){
                passconsist=true;
            }
        }
        if((idconsist==true)&&(passconsist==true)){
            consist=true;
        }
        return consist;
    }

    public void addBooking(String cusID, String plateNo, String pickdate, String dropDate ){
        String bikeid="";
        String carid="";
        if(plateNo.substring(0,1).equals("P")){
            carid=plateNo;
        }else if(plateNo.substring(0,1).equals("B")){
            bikeid=plateNo;
        }
        try {
            //Car car = new Car();
            String dbName = "cwoop_2019";
            String cusID2 = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID2, cusPass);
            //inserting data to the Car table in DB

            String contquery2 = "INSERT INTO shedule (CustomerID,CarPlateNo,BikePlateNo,Pickupdate,DropofDate)VALUES(?,?,?,?,?)";
            PreparedStatement contpst2 = cont.prepareStatement(contquery2);
            contpst2.setString(1, cusID);
            contpst2.setString(2, carid);
            contpst2.setString(3, bikeid);
            contpst2.setString(4, pickdate);
            contpst2.setString(5, dropDate);
            contpst2.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    public void addCustomer(String useridtxt,String usernametxt, String userpasstxt){
        try {
            //Car car = new Car();
            String dbName = "cwoop_2019";
            String cusID2 = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID2, cusPass);
            //inserting data to the Car table in DB

            String contquery2 = "INSERT INTO customer (CustomerID,UserName,Password)VALUES(?,?,?)";
            PreparedStatement contpst2 = cont.prepareStatement(contquery2);
            contpst2.setString(1, useridtxt);
            contpst2.setString(2, usernametxt);
            contpst2.setString(3, userpasstxt);
            contpst2.executeUpdate();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }


    }

    private void  CarCheck(){
        try {
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query2 = "SELECT * FROM car";
            // create the java statement
            Statement st2 = cont.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs2 = st2.executeQuery(query2);

            while (rs2.next()) {
                Cars.add(rs2.getString("PlateNo"));
            }
            st2.close();
            System.out.println("Car Table was successfully added from the database");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    private void  BikeCheck(){
        try {
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query3 = "SELECT * FROM motorbike";
            // create the java statement
            Statement st3 = cont.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs3 = st3.executeQuery(query3);

            while (rs3.next()) {
                Bikes.add(rs3.getString("PlateNo"));
            }
            st3.close();
            System.out.println("Car Table was successfully added from the database");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    private void  Shedule(){
        try {
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query4 = "SELECT * FROM shedule";
            // create the java statement
            Statement st4 = cont.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs4 = st4.executeQuery(query4);

            while (rs4.next()) {
                SheduleCar.add(rs4.getString("CarPlateNo"));
                SheduleBike.add(rs4.getString("BikePlateNo"));                ;
            }
            st4.close();
            System.out.println("Car Table was successfully added from the database");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    private void CustomerCheck(){
        try {
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query2 = "SELECT * FROM customer";
            // create the java statement
            Statement st2 = cont.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs2 = st2.executeQuery(query2);

            while (rs2.next()) {
                cusName.add(rs2.getString("CustomerID"));
                cuspass.add(rs2.getString("Password"));
            }
            st2.close();

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
