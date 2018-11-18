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

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "ActivitiesOfMachines",
            joinColumns = { @JoinColumn(name = "activitie_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "machine_id",referencedColumnName = "id") })
    private List<Machine> machines;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "MaterialsOfActivities",
            joinColumns = { @JoinColumn(name = "activity_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "material_id",referencedColumnName = "id") })
    private List<Material> materials;


    public Activity(){}

    public Activity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
