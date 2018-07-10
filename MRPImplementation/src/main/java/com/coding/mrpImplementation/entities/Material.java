package com.coding.mrpImplementation.entities;

public class Material {
    private String id;
    private String name;
    private int inventoryOnHand;
    private int orderingCost;
    private int maintainCost;


    public Material(String id, String name,int inventoryOnHand,int orderingCost,int maintainCost){
        this.id=id;
        this.name=name;
        this.inventoryOnHand=inventoryOnHand;
        this.orderingCost=orderingCost;
        this.maintainCost=maintainCost;
    }

    public int getInventoryOnHand() {
        return inventoryOnHand;
    }

    public void setInventoryOnHand(int inventoryOnHand) {
        this.inventoryOnHand = inventoryOnHand;
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
}
