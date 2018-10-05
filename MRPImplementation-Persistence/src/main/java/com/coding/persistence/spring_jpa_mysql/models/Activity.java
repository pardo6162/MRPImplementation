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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Machine> getMachines() {
        return machines;
    }

    public void setMachines(ArrayList<Machine> machines) {
        this.machines = machines;
    }

    public HashMap<Material, Integer> getMaterials() {
        return materials;
    }

    public void setMaterials(HashMap<Material, Integer> materials) {
        this.materials = materials;
    }

    public HashMap<Machine, ArrayList<Integer>> getCalendar() {
        return calendar;
    }

    public void setCalendar(HashMap<Machine, ArrayList<Integer>> calendar) {
        this.calendar = calendar;
    }






}
