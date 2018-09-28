package com.coding.persistence.spring_jpa_mysql.models;

import com.coding.persistence.spring_jpa_mysql.models.Activity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

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


    public Material(String id, String name,int initialInventoryOnHand,int orderingCost,int maintainCost,int securityStock,int sizeOfLot,int availablePrev,int period){
        this.id=id;
        this.name=name;
        this.initialInventoryOnHand=initialInventoryOnHand;
        this.orderingCost=orderingCost;
        this.maintainCost=maintainCost;
        this.securityStock=securityStock;
        this.sizeOfLot=sizeOfLot;
        this.availablePrev=availablePrev;
        this.period=period;
        activities=new ArrayList<>();
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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




    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public ArrayList<Activity> getActivities(){
        return activities;
    }

    public void setActivity(Activity activity){
        if(!activities.contains(activity)){
            activities.add(activity);
        }
    }
}
