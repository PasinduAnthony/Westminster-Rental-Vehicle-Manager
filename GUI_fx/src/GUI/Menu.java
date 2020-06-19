package GUI;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu extends Application {

    Stage window;
    Scene menuScene,viewScene,bookingScene,loginScene,UserScene,signScene;
    TableView<GUI.Car> table;
    TableView<GUI.MotorBike> table2;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        dbcheck check = new dbcheck();
        Label label2 = new Label("Car Table");
        Label label3 = new Label("MotorBike Table");
        //button1
        Button button1 = new Button("View All");
        button1.setOnAction(e -> window.setScene(viewScene));

        //Button2
        Button button2 = new Button("Manage Bookings");
        button2.setOnAction(e -> window.setScene(bookingScene));

        //button3
        Button button3 = new Button("Menu");
        button3.setOnAction(e -> window.setScene(menuScene));

        //button4
        Button button4 = new Button("Menu");
        button4.setOnAction(e -> window.setScene(menuScene));

        //For Login User scene lbls and textFields
            Label loginidlbl = new Label("Enter Customer ID : ");
            TextField loginidtxt = new TextField();
            Label loginpasslbl = new Label("Enter your Password : ");
            TextField loginpasstxt = new TextField();
            Button submitloginbtn = new Button("Login");
            TextField displaytxt2 = new TextField();
            submitloginbtn.setOnAction(e -> {
                if((check.Login(loginidtxt.getText(),loginpasstxt.getText()))==true){
                    window.setScene(menuScene);
                }else{
                    displaytxt2.setText("Incorrect Data");
                    window.close();
                }

            });
            //clearbtn
            Button clearbtn2 = new Button("Clear");
            clearbtn2.setOnAction(e -> {
                loginidtxt.setText("");
                loginpasstxt.setText("");
            });
            //layout 0
            VBox LoginUsr = new VBox(20);
            LoginUsr.getChildren().addAll(loginidlbl,loginidtxt,loginpasslbl,loginpasstxt,submitloginbtn,clearbtn2);
            signScene = new Scene(LoginUsr,500,400);


        //For Create User scene lbls and textFields
            Label useridlbl = new Label("Enter Customer ID : ");
            TextField useridtxt = new TextField();
            Label usernamelbl = new Label("Enter User Name : ");
            TextField usernametxt = new TextField();
            Label userpasslbl = new Label("Enter Password : ");
            TextField userpasstxt = new TextField();
            TextField displaytxt = new TextField();
            //submitbtn
            Button submitbtn1 = new Button("SignUp");
            submitbtn1.setOnAction(e -> {
                check.addCustomer(useridtxt.getText(),usernametxt.getText(),userpasstxt.getText());
                displaytxt.setText("Customer was Successfully Created : (Customer ID : "+useridtxt.getText()+" Customer Name : "+usernamelbl.getText());
                window.setScene(menuScene);
            });
            //clearbtn
            Button clearbtn1 = new Button("Clear");
            clearbtn1.setOnAction(e -> {
                useridtxt.setText("");
                usernametxt.setText("");
                userpasstxt.setText("");
            });
            //layout 0
            VBox createUsr = new VBox(20);
            createUsr.getChildren().addAll(useridlbl,useridtxt,usernamelbl,usernametxt,userpasslbl,userpasstxt,submitbtn1,clearbtn1,displaytxt);
            UserScene = new Scene(createUsr,500,400);

        //logbutton
        Button logbtn1 = new Button("Login");
        logbtn1.setOnAction(e -> {
            window.setScene(signScene);
        });

        //createbtn
        Button createbtn1 = new Button("SignUp");
        createbtn1.setOnAction(e -> {
            window.setScene(UserScene);
        });

        //layout 0
        VBox layout0 = new VBox(20);
        layout0.getChildren().addAll(button1,button2);
        menuScene = new Scene(layout0,200,200);

        //layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(logbtn1,createbtn1);
        loginScene = new Scene(layout1,200,200);


        //table
            //PlateNo Col
            TableColumn<GUI.Car,String> plateCol = new TableColumn<>("Plate NO");
            plateCol.setMinWidth(100);
            plateCol.setCellValueFactory(new PropertyValueFactory<>("PlateNo"));

            //Make Col
            TableColumn<GUI.Car,String> makeCol = new TableColumn<>("Make");
            makeCol.setMinWidth(100);
            makeCol.setCellValueFactory(new PropertyValueFactory<>("Make"));

            //Engine Col
            TableColumn<GUI.Car,Integer> engineCol = new TableColumn<>("Engine Capacity");
            engineCol.setMinWidth(100);
            engineCol.setCellValueFactory(new PropertyValueFactory<>("EngineCapacity"));

            //Price Col
            TableColumn<GUI.Car,Double> priceCol = new TableColumn<>("Price");
            priceCol.setMinWidth(100);
            priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

            //Speed Col
            TableColumn<GUI.Car,Integer> speedCol = new TableColumn<>("Top Speed");
            speedCol.setMinWidth(100);
            speedCol.setCellValueFactory(new PropertyValueFactory<>("topSpeed"));

            //Fuel Col
            TableColumn<GUI.Car,Integer> fuelCol = new TableColumn<>("Fuel Capacity");
            fuelCol.setMinWidth(100);
            fuelCol.setCellValueFactory(new PropertyValueFactory<>("FuelCapacity"));

            //Seat Col
            TableColumn<GUI.Car,Integer> seatCol = new TableColumn<>("Seat Capacity");
            seatCol.setMinWidth(100);
            seatCol.setCellValueFactory(new PropertyValueFactory<>("SeatCapacity"));

            //doors Col
            TableColumn<GUI.Car,Integer> doorsCol = new TableColumn<>("No of Doors");
            doorsCol.setMinWidth(100);
            doorsCol.setCellValueFactory(new PropertyValueFactory<>("NoofDoor"));

            //wagon Col
            TableColumn<GUI.Car,Boolean> wagonCol = new TableColumn<>("Wagon");
            wagonCol.setMinWidth(100);
            wagonCol.setCellValueFactory(new PropertyValueFactory<>("isWagon"));

            //ac Col
            TableColumn<GUI.Car,Boolean> acCol = new TableColumn<>("AirConditioned");
            acCol.setMinWidth(100);
            acCol.setCellValueFactory(new PropertyValueFactory<>("isAirConditioned"));

            //airbags Col
            TableColumn<GUI.Car,Boolean> airbagsCol = new TableColumn<>("Airbags");
            airbagsCol.setMinWidth(100);
            airbagsCol.setCellValueFactory(new PropertyValueFactory<>("hasAirBags"));

            //carid Col
            TableColumn<GUI.Car,Integer> caridCol = new TableColumn<>("CarID");
            caridCol.setMinWidth(100);
            caridCol.setCellValueFactory(new PropertyValueFactory<>("CarID"));

            table = new TableView<>();
            table.setItems(getCars());
            table.getColumns().addAll(plateCol,makeCol,engineCol,seatCol,priceCol,speedCol,fuelCol,doorsCol,wagonCol,acCol,airbagsCol,caridCol);


        //table2
            //PlateNo Col
            TableColumn<GUI.MotorBike,String> plateCol2 = new TableColumn<>("Plate NO");
            plateCol2.setMinWidth(100);
            plateCol2.setCellValueFactory(new PropertyValueFactory<>("PlateNo"));

            //Make Col
            TableColumn<GUI.MotorBike,String> makeCol2 = new TableColumn<>("Make");
            makeCol2.setMinWidth(100);
            makeCol2.setCellValueFactory(new PropertyValueFactory<>("Make"));

            //Engine Col
            TableColumn<GUI.MotorBike,Integer> engineCol2 = new TableColumn<>("Engine Capacity");
            engineCol2.setMinWidth(100);
            engineCol2.setCellValueFactory(new PropertyValueFactory<>("EngineCapacity"));

            //Price Col
            TableColumn<GUI.MotorBike,Double> priceCol2 = new TableColumn<>("Price");
            priceCol2.setMinWidth(100);
            priceCol2.setCellValueFactory(new PropertyValueFactory<>("price"));

            //Speed Col
            TableColumn<GUI.MotorBike,Integer> speedCol2 = new TableColumn<>("Top Speed");
            speedCol2.setMinWidth(100);
            speedCol2.setCellValueFactory(new PropertyValueFactory<>("topSpeed"));

            //Fuel Col
            TableColumn<GUI.MotorBike,Integer> fuelCol2 = new TableColumn<>("Fuel Capacity");
            fuelCol2.setMinWidth(100);
            fuelCol2.setCellValueFactory(new PropertyValueFactory<>("FuelCapacity"));

            //Seat Col
            TableColumn<GUI.MotorBike,Integer> seatCol2 = new TableColumn<>("Seat Capacity");
            seatCol2.setMinWidth(100);
            seatCol2.setCellValueFactory(new PropertyValueFactory<>("SeatCapacity"));

            //doors Col
            TableColumn<GUI.MotorBike,Integer> helmetsCol = new TableColumn<>("No of Helmets");
            helmetsCol.setMinWidth(100);
            helmetsCol.setCellValueFactory(new PropertyValueFactory<>("noOfHelmets"));

            //wagon Col
            TableColumn<GUI.MotorBike,Boolean> bikeidCol = new TableColumn<>("Bike ID");
            bikeidCol.setMinWidth(100);
            bikeidCol.setCellValueFactory(new PropertyValueFactory<>("BikeID"));

            table2 = new TableView<>();
            table2.setItems(getBikes());
            table2.getColumns().addAll(plateCol2,makeCol2,engineCol2,seatCol2,priceCol2,speedCol2,fuelCol2,helmetsCol,bikeidCol);

        //button5
        Button button5 = new Button("Order by Make");
        button5.setOnAction(e -> {
            makeCol.setSortType(TableColumn.SortType.ASCENDING);
            makeCol2.setSortType(TableColumn.SortType.ASCENDING);
        });

        //layout 3
        HBox layout3 = new HBox(20);
        layout3.getChildren().addAll(button4,button5);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(layout3,label2,table,label3,table2);
        viewScene = new Scene(vBox,1200,500);

        //textField
        TextField plateInput = new TextField();


        //lablel
        Label label4 = new Label();


        //lablel
        Label label5 = new Label("Enter your customer ID : ");

        //lablel
        Label label6 = new Label("Enter your Plate No : ");

        //lablel
        Label label7 = new Label("Enter PickupDate (YYYY-MM-DD) : ");

        //lablel
        Label label8 = new Label("Enter Drop Date input (YYYY-MM-DD)  : ");

        //textField
        TextField pickdateInput = new TextField();

        //textField
        TextField dropdateInput = new TextField();

        //textField
        TextField cusIDInput = new TextField();

        //button6
        Button button6 = new Button("Make Order");
        button6.setOnAction(e -> {
            if((check.Checkdate(plateInput.getText()))==false){
                check.addBooking(cusIDInput.getText(),plateInput.getText(),pickdateInput.getText(),dropdateInput.getText());
            }else{
                label4.setText("Vehicle is already Booked Available");
                cusIDInput.setText("");
                plateInput.setText("");
                pickdateInput.setText("");
                dropdateInput.setText("");
            }
        });

        //layout 2
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(button3,label4,label5,cusIDInput,label6,plateInput,label7,pickdateInput,label8,dropdateInput,button6);
        bookingScene = new Scene(layout2,500,500);

        window.setScene(loginScene);
        window.setTitle("Westminster Rental Vehicle Manager (WRVM)");
        window.show();
    }
    public ObservableList<GUI.Car> getCars() {
        ObservableList<GUI.Car> vehicles = FXCollections.observableArrayList();
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
                GUI.Car carRead = new GUI.Car();
                carRead.PlateNo = rs2.getString("PlateNo");
                carRead.Make = rs2.getString("Make");
                carRead.EngineCapacity = rs2.getInt("EngineCapacity");
                carRead.SeatCapacity = rs2.getInt("SeatCapacity");
                carRead.price = rs2.getDouble("Price");
                carRead.topSpeed = rs2.getInt("TopSpeed");
                carRead.FuelCapacity = rs2.getInt("FuelCapacity");
                carRead.NoOfDoor = rs2.getInt("noOFDoors");
                carRead.isWagon = rs2.getBoolean("isWagon");
                carRead.isAirConditioned = rs2.getBoolean("isAirConditioned");
                carRead.hasAirBags = rs2.getBoolean("hasAirbags");
                carRead.CarID = rs2.getInt("carID");
                vehicles.add(new GUI.Car(carRead.PlateNo, carRead.Make, carRead.EngineCapacity, carRead.SeatCapacity, carRead.price, carRead.topSpeed, carRead.FuelCapacity, carRead.NoOfDoor,carRead.isWagon, carRead.isAirConditioned, carRead.hasAirBags, carRead.CarID));
            }
            st2.close();
            System.out.println("Car Table was successfully added from the database");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return vehicles;
    }

    public ObservableList<GUI.MotorBike> getBikes() {
        ObservableList<GUI.MotorBike> vehicleBike = FXCollections.observableArrayList();
        try {
            String dbName = "cwoop_2019";
            String cusID = "root";
            String cusPass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, cusID, cusPass);


            String query = "SELECT * FROM motorbike";
            // create the java statement
            Statement st = cont.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                GUI.MotorBike bikeRead = new GUI.MotorBike();
                bikeRead.PlateNo = rs.getString("PlateNo");
                bikeRead.Make = rs.getString("Make");
                bikeRead.EngineCapacity = rs.getInt("EngineCapacity");
                bikeRead.SeatCapacity = rs.getInt("SeatCapacity");
                bikeRead.price = rs.getDouble("Price");
                bikeRead.topSpeed = rs.getInt("TopSpeed");
                bikeRead.FuelCapacity = rs.getInt("FuelCapacity");
                bikeRead.noOfHelmets = rs.getInt("noofHelmets");
                bikeRead.BikeID = rs.getInt("bikeID");
                vehicleBike.add(new GUI.MotorBike(bikeRead.PlateNo, bikeRead.Make, bikeRead.EngineCapacity, bikeRead.SeatCapacity, bikeRead.price, bikeRead.topSpeed, bikeRead.FuelCapacity, bikeRead.noOfHelmets,bikeRead.BikeID));
            }
            st.close();
            System.out.println("Car Table was successfully added from the database");
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return vehicleBike;
    }
}
