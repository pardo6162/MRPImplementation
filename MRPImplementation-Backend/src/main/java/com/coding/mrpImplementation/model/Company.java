package com.coding.mrpImplementation.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Company {

    @Id
    private String id;
    private String name;
    private String nit;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "MachineOfCompanies",
            joinColumns = { @JoinColumn(name = "Companies_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "Machines_id",referencedColumnName = "id") })
    private List<Machine>  machines;
    private Schedule schedule;
    private Inventory inventory;


    public Company(){

    }

    public Company(String id, String name, String nit) {
        this.id = id;
        this.name = name;
        this.nit = nit;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
