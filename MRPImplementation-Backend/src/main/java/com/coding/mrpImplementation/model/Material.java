package com.coding.mrpImplementation.model;

import java.util.ArrayList;
import java.util.Map;

public class Material {
    private String id;
    private String name;
    private int initialInventoryOnHand;
    private int orderingCost;
    private int maintainCost;
    private ArrayList<com.coding.mrpImplementation.model.Activity> activities;
    private int securityStock;
    private int sizeOfLot;
    private int availablePrev;
    private int period;
    private int[] inventoryOnHand;
    private int[] programedReceptions;
    private Map<Activity,Integer> quantity;

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

    public ArrayList<com.coding.mrpImplementation.model.Activity> getActivities(){
        return activities;
    }

    public void setActivity(Activity activity){
        if(!activities.contains(activity)){
            activities.add(activity);
        }
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

    public Map<Activity,Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<Activity,Integer> quantity) {
        this.quantity = quantity;
    }
}
