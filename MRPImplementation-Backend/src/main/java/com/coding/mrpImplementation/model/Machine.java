package com.coding.mrpImplementation.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Machine {

    @Id
    private String id;
    private String name;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="company_nit")
    private Company company;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "Activity",
            joinColumns = { @JoinColumn(name = "machine_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "id",referencedColumnName = "id") })
    private List<Activity> activities;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
