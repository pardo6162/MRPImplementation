package com.coding.mrpImplementation.entities;

import java.util.ArrayList;

public class Material {
    private String id;
    private String name;
    private int initialInventoryOnHand;
    private int orderingCost;
    private int maintainCost;
    private ArrayList<Activity> activities;


    public Material(String id, String name,int initialInventoryOnHand,int orderingCost,int maintainCost){
        this.id=id;
        this.name=name;
        this.initialInventoryOnHand=initialInventoryOnHand;
        this.orderingCost=orderingCost;
        this.maintainCost=maintainCost;
        activities=new ArrayList<>();
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
