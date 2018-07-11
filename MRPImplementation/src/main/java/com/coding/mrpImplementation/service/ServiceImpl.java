package com.coding.mrpImplementation.service;

import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.MRP.*;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.HashMap;

public class ServiceImpl implements Service{


    private int securityStock;
    private int sizeOfLot;
    private int availablePrev;
    private int time;
    private int period;

    private HashMap<String,Machine> machines;
    private HashMap<String,Activity> activities;
    private HashMap<String,Material> materials;

    public ServiceImpl(int securityStock,int sizeOfLot,int availablePrev,int time,int period){
        machines= new HashMap<>();
        activities= new HashMap<>();
        materials= new HashMap<>();
        this.securityStock=securityStock;
        this.sizeOfLot=sizeOfLot;
        this.availablePrev=availablePrev;
        this.time=time;
        this.period=period;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
    @Override
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


    @Override
    public HashMap<Material,int[]> plaining(String lotMethod) throws MRPException {
        Object instance;
        HashMap<Material,int[]> resultHashMap=new HashMap<>();
        try {
            instance = Class.forName("com.coding.mrpImplementation.MRP.lotMethods." + lotMethod);
            MRP methodInstance=(MRP) instance;
            for (Material j : materials.values()) {
                int[] planingPeriods=new int[time];
                for (int i = 0; i < time; i++) {
                    planingPeriods[i]=methodInstance.execute(this,j,i);
                }
                resultHashMap.put(j,planingPeriods);
            }
        }catch(ClassNotFoundException ex){
            throw new MRPException(ex);
        }
        return null;
    }

    @Override
    public int netRequirement(int timeIndex,String idMaterial){
        int requirement=0;
        if(inventoryOnHand(timeIndex,idMaterial)<=securityStock){
            requirement=securityStock-inventoryOnHand(timeIndex,idMaterial);
        }
        return requirement;
    }

    @Override
    public int inventoryOnHand(int timeIndex,String idMaterial){
        materials.get(idMaterial).getInitialInventoryOnHand();
    }

    @Override
    public void addMachine(Machine machine) throws MRPException {
        if(!machines.containsValue(machine)){
            machines.put(machine.getId(),machine);
        }
    }

    @Override
    public void addAcivityToMachine(String idActivity, String idMachine) throws MRPException {
        if(machines.containsKey(idMachine)){
            if(activities.containsKey(idActivity)){
                machines.get(idMachine).setActivity(activities.get(idActivity));
            }
        }
    }

    @Override
    public void addMaterialToActivity(String idMaterial, String idActivity) throws MRPException {
        if(activities.containsKey(idActivity)){
            if(materials.containsKey(idMaterial)){
                activities.get(idActivity).setMaterial(materials.get(idMaterial));
            }
        }
    }

    @Override
    public ArrayList<Machine> getMachines() throws MRPException {
        return new ArrayList<Machine>(machines.values());
    }

    @Override
    public ArrayList<Activity> getActivities() throws MRPException {
        return new ArrayList<Activity>(activities.values());
    }

    @Override
    public ArrayList<Material> getMaterials() throws MRPException {
        return new ArrayList<Material>(materials.values());
    }

    @Override
    public void addMaterial(Material material) throws MRPException {
        if(!materials.containsValue(material)){
            materials.put(material.getId(),material);
        }
    }

    @Override
    public void addActivity(Activity activity) throws MRPException {
        if(!activities.containsValue(activity)){
            activities.put(activity.getId(),activity);
        }
    }
}
