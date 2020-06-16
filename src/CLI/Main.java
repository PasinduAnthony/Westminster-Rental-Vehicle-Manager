package CLI;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        WestminsterRentalVehicleManager obj1 = new WestminsterRentalVehicleManager();

        int Choice=0;
        obj1.Starting();
        while(Choice!=5){
        System.out.println("Type : \n 1 : Add vehicle \n 2 : Delete vehicle \n 3 : View Vehicles \n 0 : Exit");
        Choice = input.nextInt();
            switch (Choice) {
                //ADD Vehicle
                case 1:
                    System.out.println("Input the plate No : ");
                    String input2 = input.next();
                    System.out.println("Input the Make : ");
                    String input3 = input.next();
                    System.out.println("Engine Capacity : ");
                    int input4 = input.nextInt();
                    System.out.println("Seat Capacity : ");
                    int input5 = input.nextInt();
                    System.out.println("Price : ");
                    double input6 = input.nextDouble();
                    System.out.println("Enter the topSpeed : ");
                    int input7 = input.nextInt();
                    System.out.println("Fuel Capacity : ");
                    int input8 = input.nextInt();

                    System.out.println("Car(c) or MotorBike(m) ? ");
                    String input1 = input.next();
                    if (input1.equals("c")) {
                        System.out.println("No of Doors : ");
                        int input9 = input.nextInt();
                        System.out.println("Is Wagon (true/false) : ");
                        Boolean input10 = input.nextBoolean();
                        System.out.println("Air Conditioned (true/false) : ");
                        Boolean input11 = input.nextBoolean();
                        System.out.println("has AirBags (true/false) : ");
                        Boolean input12 = input.nextBoolean();
                        System.out.println("Enter the CarID : ");
                        int caID = input.nextInt();
                        Car carAdd = new Car(input2, input3, input4, input5, input6, input7, input8, input9, input10, input11, input12, caID);
                        obj1.addVehicle(carAdd);

                    } else if (input1.equals("m")) {
                        System.out.println("No of Helmets : ");
                        int input13 = input.nextInt();
                        System.out.println("Enter the BikeID : ");
                        int baID = input.nextInt();
                        MotorBike bikeAdd = new MotorBike(input2, input3, input4, input5, input6, input7, input8, input13, baID);
                        obj1.addVehicle(bikeAdd);

                    } else {
                        System.out.println("Only input (c) / (m)");
                    }

                    break;
                case 2:
                    //Delete Vehicle
                    System.out.println("Enter the plate number to delete vehicle: ");
                    String bin = input.next();
                    WestminsterRentalVehicleManager delete = new WestminsterRentalVehicleManager();
                    delete.deleteVehicle(bin);
                    break;
                case 3:
                    //View Vehicle
                    System.out.println("To View \n1 : Cars\n2 : MotorBikes\n3 : View All");
                    int c41 = input.nextInt();
                    if (c41 == 1) {
                        obj1.setVehicleType("car");
                        obj1.viewVehicle();
                    } else if (c41 == 2) {
                        obj1.setVehicleType("bike");
                        obj1.viewVehicle();
                    } else if (c41 == 3){
                        obj1.setVehicleType("all");
                        obj1.viewVehicle();
                    }else {
                        System.out.println("Please input 1/2");
                    }
                    break;

                case 0: {
                    obj1.Finalizing();
                    break;
                }
                default:

            }

        }
    }

}
