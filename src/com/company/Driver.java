package com.company;

import java.lang.reflect.Type;

public class Driver {
    private int id;
    private String idDriver;
    private String name;
    private String bus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return bus;
    }

    public void setCar(String bus) {
        this.bus = bus;
    }

    public String getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(String idDriver) {
        this.idDriver = idDriver;
    }

    public static Driver makeDriver(int id,String idDriver, String name, String bus){
        Driver driver=new Driver();
        driver.id = id;
        driver.idDriver=idDriver;
        driver.name=name;
        driver.bus=bus;

        return driver;
    }

    @Override
    public String toString() {
        return id+"\t|"+idDriver+"\t\t|"+name+"\t\t" + "|"+ bus  ;
    }
}
