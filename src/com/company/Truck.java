package com.company;


import java.util.Random;

public class Truck {

    private int id;
    private String name;
    private String driver;
    private State state;

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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static Truck makeTruck(int id, String name,String driver,State state){
        Truck truck=new Truck();
        truck.id = id;
        truck.name=name;
        truck.driver=driver;
        truck.state =state;

        return truck;
    }
    public static void changeDriver(Truck truck,Driver[] drivers){
        for(Driver driver: drivers){
            if(truck.getState().equals(State.ON_BASE) ){
                if(truck.getDriver()==""){
                    for (int i = 0; i < drivers.length; i++) {
                        if(drivers[drivers.length-1].getCar()!=""){
                            System.out.println("Bow aydoochu jok");
                            break;
                        }
                    }
                    for (int i=0; i<drivers.length;i++){
                        if(drivers[i].getCar()==""){
                            System.out.println("---------------------------");
                            System.out.println("---------------------------");
                            truck.setDriver(drivers[i].getName());
                            drivers[i].setCar(truck.getName());

                            break;
                        }
                    }break;
                }else if(truck.getDriver()!=""){
                    for (int i = 0; i < drivers.length; i++) {
                        if(drivers[i].getCar()==truck.getName()){
                            truck.setDriver("");
                            if(truck.getDriver()=="") {
                                for (int j = 0; j < drivers.length; j++) {
                                    if (drivers[j].getCar() == "") {
                                        truck.setDriver(drivers[j].getName());
                                        drivers[j].setCar(truck.getName());
                                        break;
                                    }
                                } drivers[i].setCar("");
                            }
                            break;
                       }
                        break;
                    }
                }
            } else if(truck.getState().equals(State.ON_ROAD)){
                System.out.println("Mawina joldo ketip jatat, aydoochusun almashtyruuga bolboyt");
                break;
            }else if (truck.getState().equals(State.ON_REPAIR)) {
                System.out.println("Mawina remontto, aydoochunu almashtyruuga bolboyt");
                break;
            }else {
                System.out.println("");
                break;
            }
        }
    }
    public static void startDriving(Truck truck){
        if (truck.state.equals(State.ON_BASE)){
            if(truck.getDriver()!=""){
                truck.setState(State.ON_ROAD);
                System.out.println("---------------------------");
                System.out.println("Successfully completed the route");
                System.out.println("---------------------------");
            }else if(truck.getDriver()==""){
                System.out.println("Aydoochusu jok, jolgo chyguuga bolboyt");
            }
        }else if (truck.state.equals(State.ON_ROAD)){
            System.out.println("Truck already on road!");
        }else if(truck.getState().equals(State.ON_REPAIR)){
            Random random = new Random();
            int baseOrRoad = random.nextInt(2);
            if (baseOrRoad == 1) {
                truck.setState(State.ON_BASE);
                System.out.println("Mashina ondolgon jok, bazaga ketti");
            } else {
                truck.setState(State.ON_ROAD);
                System.out.println("Mashina ondoldu janan kayra jolgo chykty");
            }
        }
    }

    public static void startRepair(Truck truck) {

        if (truck.state.equals(State.ON_BASE)){
            if(truck.getDriver()==""){
                System.out.println("Mashinanyn aydoochusu jok, jolgo chyga albayt");
            }else if(truck.getDriver()!=""){
                truck.setState(State.ON_REPAIR);
            }
        }else if(truck.state.equals(State.ON_ROAD)){
            truck.setState(State.ON_REPAIR);
            System.out.println("Mashina remontko ketti");
        }else if (truck.state.equals(State.ON_REPAIR)){
            System.out.println("Truck already on repair!");
        }
    }
    @Override
    public String toString() {
        return  id +"\t|"+name+"\t\t |"+driver+"\t\t|"+state;
    }
}
