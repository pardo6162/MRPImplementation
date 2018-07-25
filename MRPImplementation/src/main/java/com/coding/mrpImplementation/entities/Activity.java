package com.coding.mrpImplementation.entities;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity {

    private String id;
    private String name;
    private ArrayList<Machine> machines;
    private ArrayList<Material> materials;
    private HashMap<Machine,ArrayList<Integer>> calendar;


    public Activity(String id, String name) {
        this.id = id;
        this.name = name;
        machines=new ArrayList<>();
        materials=new ArrayList<>();
        calendar = new HashMap<>();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterial(Material material) {
        if (!materials.contains(material)) {
            materials.add(material);
        }
    }

    public ArrayList<Machine> getMachines(){
        return machines;
    }

    public void setMachines(Machine machine){
        if(!machines.contains(machine))
            machines.add(machine);
    }

    public void addSchedule(Machine machine, int timeIndex){
        if(machines.contains(machine))
            if(!calendar.containsKey(machine)) {
                ArrayList<Integer> tempCalendar = new ArrayList<>();
                tempCalendar.add(timeIndex);
                calendar.put(machine,tempCalendar);
            }else if(!calendar.get(machine).contains(timeIndex)){
                calendar.get(machine).add(timeIndex);
            }
    }

    public HashMap<Machine,ArrayList <Integer>> getCalendar(){
        return  calendar;
    }
}
