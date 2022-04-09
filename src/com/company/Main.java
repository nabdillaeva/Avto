package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH1 = Paths.get("./driver.json");
    public static final Path WRITE_PATH2 = Paths.get("./truck.json");

    public static void main(String[] args) {
        Driver[] drivers = {
                Driver.makeDriver(1, "dv-1", "Sasha", ""),
                Driver.makeDriver(2, "dv-2", "Petya", ""),
                Driver.makeDriver(3, "dv-3", "Vasya", "")
        };
        Truck[] trucks = {
                Truck.makeTruck(1, "Honda", "", State.ON_BASE),
                Truck.makeTruck(2, "BMW", "", State.ON_BASE),
                Truck.makeTruck(3, "Toyota", "", State.ON_BASE),
                Truck.makeTruck(4, "Lexus", "", State.ON_BASE)
        };

        String json = GSON.toJson(drivers);
        String json1 = GSON.toJson(trucks);
        writeDriver(json);
        writeTruck(json1);
        Service service=new Service();
        service.etap1(trucks);
//        service.etap2(drivers);
        service.etap3(drivers,trucks);

    }
    public static void writeDriver(String a){
        Path write = Paths.get((String.valueOf(WRITE_PATH1)));
        try {
            Files.writeString(write,a, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e){
            e.getMessage();
        }
    }
    public static void writeTruck(String b){
        Path write = Paths.get((String.valueOf(WRITE_PATH2)));
        try {
            Files.writeString(write,b, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e){
            e.getMessage();
        }
    }
    private static String readDriver() {
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH1));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char)a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    private static String readTruck() {
        String json = "";
        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH2));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char)a;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
