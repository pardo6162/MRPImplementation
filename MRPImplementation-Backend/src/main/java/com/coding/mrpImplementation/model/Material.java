package com.coding.mrpImplementation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class Material {
    @Id
    private String id;
    private String name;
    private int orderingCost;
    private int maintainCost;

    @JsonIgnore
    @ManyToMany(mappedBy = "materials")
    private List<Activity> activities;

    @JsonIgnore
    @ManyToMany(mappedBy = "materials")
    private List<Supplier> suppliers;

    public  Material(){}

    public Material(String id, String name,int initialInventoryOnHand,int orderingCost,int maintainCost,int securityStock,int sizeOfLot,int availablePrev,int period){
        this.id=id;
        this.name=name;
        this.orderingCost=orderingCost;
        this.maintainCost=maintainCost;
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

    public int getOrderingCost() {
        return orderingCost;
    }

    public void setOrderingCost(int orderingCost) {
        this.orderingCost = orderingCost;
    }

    public int getMaintainCost() {
        return maintainCost;
    }

    public void setMaintainCost(int maintainCost) {
        this.maintainCost = maintainCost;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
