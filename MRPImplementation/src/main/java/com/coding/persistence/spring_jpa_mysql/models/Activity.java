package com.coding.persistence.spring_jpa_mysql.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.coding.persistence.spring_jpa_mysql.models.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private ArrayList<com.coding.persistence.spring_jpa_mysql.models.Machine> machines;
    private HashMap<com.coding.persistence.spring_jpa_mysql.models.Material,Integer> materials;
    private HashMap<com.coding.persistence.spring_jpa_mysql.models.Machine,ArrayList<Integer>> calendar;


    public Activity(){

    }

    public Activity(Integer id, String name) {
        this.id = id;
        this.name = name;
        machines=new ArrayList<>();
        materials=new HashMap<>();
        calendar = new HashMap<>();
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<com.coding.persistence.spring_jpa_mysql.models.Material,Integer> getMaterials() {
        return materials;
    }

    public void setMaterial(com.coding.persistence.spring_jpa_mysql.models.Material material, int quantity) {
        if (!materials.keySet().contains(material)) {
            materials.put(material,quantity);
        }
    }

    public ArrayList<com.coding.persistence.spring_jpa_mysql.models.Machine> getMachines(){
        return machines;
    }

    public void setMachines(com.coding.persistence.spring_jpa_mysql.models.Machine machine){
        if(!machines.contains(machine))
            machines.add(machine);
    }

    public void addSchedule(com.coding.persistence.spring_jpa_mysql.models.Machine machine, int timeIndex){
        if(machines.contains(machine))
            if(!calendar.containsKey(machine)) {
                ArrayList<Integer> tempCalendar = new ArrayList<>();
                tempCalendar.add(timeIndex);
                calendar.put(machine,tempCalendar);
            }else if(!calendar.get(machine).contains(timeIndex)){
                calendar.get(machine).add(timeIndex);
            }
    }

    public HashMap<com.coding.persistence.spring_jpa_mysql.models.Machine,ArrayList <Integer>> getCalendar(){
        return  calendar;
    }
}
