package com.coding.mrpImplementation.model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class Activity {
    @Id
    private String id;
    private String name;
    //@OneToMany(targetEntity = Machine.class, mappedBy = "activity")
    //private List<Machine> machines;
    //private List<Material> materials;
    //private Map<Machine, ArrayList<Integer>> calendar;

    public Activity(){}

    public Activity(String id, String name) {
        this.id = id;
        this.name = name;
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
    /**
    public List<Material> getMaterials() {
        return materials;
    }

    public List<Machine> getMachines(){
        return machines;
    }


    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public Map<Machine, ArrayList<Integer>> getCalendar() {
        return calendar;
    }

    public void setCalendar(Map<Machine, ArrayList<Integer>> calendar) {
        this.calendar = calendar;
    }

**/
}
