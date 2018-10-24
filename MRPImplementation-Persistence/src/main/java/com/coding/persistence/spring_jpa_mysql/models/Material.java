package com.coding.persistence.spring_jpa_mysql.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


@Entity
public class Material {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String name;
    private int initialInventoryOnHand;
    private int orderingCost;
    private int maintainCost;
    private ArrayList<Activity> activities;
    private int securityStock;
    private int sizeOfLot;
    private int availablePrev;
    private int period;
    private int[] inventoryOnHand;

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

    public int getInitialInventoryOnHand() {
        return initialInventoryOnHand;
    }

    public void setInitialInventoryOnHand(int initialInventoryOnHand) {
        this.initialInventoryOnHand = initialInventoryOnHand;
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

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public int getSecurityStock() {
        return securityStock;
    }

    public void setSecurityStock(int securityStock) {
        this.securityStock = securityStock;
    }

    public int getSizeOfLot() {
        return sizeOfLot;
    }

    public void setSizeOfLot(int sizeOfLot) {
        this.sizeOfLot = sizeOfLot;
    }

    public int getAvailablePrev() {
        return availablePrev;
    }

    public void setAvailablePrev(int availablePrev) {
        this.availablePrev = availablePrev;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int[] getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(int[] inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
    }

    public int[] getProgramedReceptions() {
        return programedReceptions;
    }

    public void setProgramedReceptions(int[] programedReceptions) {
        this.programedReceptions = programedReceptions;
    }

    private int[] programedReceptions;
}
