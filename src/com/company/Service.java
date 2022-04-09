package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Service {
    public Service() {
    }
    Scanner scanner = new Scanner(System.in);

    public void etap1(Truck[]trucks){
        System.out.println("------------------Trucks-----------------");
        System.out.println(" # | Bus         | Driver       | State\n" +
                "---+-------------+-------------+--------");
        Arrays.stream(trucks).forEach(System.out::println);

    }
    public void etap2(Driver[] drivers){
        System.out.println("\n---------------Drivers--------------");
        System.out.println(" #  | id       | Driver   | Bus \n" +
                "----+----------+------------+---------");
        Arrays.stream(drivers).forEach(System.out::println);
    }
    public void etap3(Driver[]drivers,Truck[] trucks) {
        while(true) {
            System.out.println("Choose one of the Truck:");
            int idTrucks = scanner.nextInt();
            System.out.println("----------Trucks-INF---------");

            for (Truck truck : trucks) {
                if (idTrucks == truck.getId()) {
                    System.out.println("N\t\t\t:" + truck.getId() + "\n" +
                            "Bus\t\t\t:" + truck.getName() + "\n" +
                            "Driver\t\t:" + truck.getDriver() + "\n" +
                            "Bus State\t:" + truck.getState());


                    System.out.println("Press 1 to change Driver");
                    System.out.println("Press 2 to send to the Route");
                    System.out.println("Press 3 to send to the repairing");

                    int changeNumber = scanner.nextInt();
                    if (changeNumber == 1) {
                        Truck.changeDriver(truck, drivers);


                        System.out.println("\n-------------Drivers----------------");
                        System.out.println(" #  | id         | Driver   | Bus \n" +
                                "----+------------+----------+--------\n");
                         Arrays.stream(drivers).forEach(System.out::println);
                        System.out.println("");

                        System.out.println("------------------Trucks-------------");
                        System.out.println(" # | Bus          | Driver       | State\n" +
                                "---+--------------+--------------+--------");
                        Arrays.stream(trucks).forEach(System.out::println);
                        break;
                    } else if (changeNumber == 2) {
                        Truck.startDriving(truck);
                        System.out.println("------------------Trucks-------------");
                        System.out.println(" # | Bus         | Driver      | State\n" +
                                "---+-------------+-------------+--------");
                        Arrays.stream(trucks).forEach(System.out::println);
                        break;
                    } else if (changeNumber == 3) {
                        Truck.startRepair(truck);
                        System.out.println("------------------Trucks-------------");
                        System.out.println(" # | Bus         | Driver      | State\n" +
                                "---+-------------+-------------+--------");
                        Arrays.stream(trucks).forEach(System.out::println);
                        break;
                    }

                }
            }
        }
    }
}
