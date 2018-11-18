package com.coding.mrpImplementation.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Machine {

    @Id
    private String id;
    private String name;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "MachineOfCompanies",
            joinColumns = { @JoinColumn(name = "Machines_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "Companies_id",referencedColumnName = "id") })
    private List<Activity> activities;
    private List<Company> companies;

    public  Machine(){}

    public Machine(String id, String name){
        this.id=id;
        this.name=name;
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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
