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

    private int time;
    private HashMap<String,Machine> machines;
    private HashMap<String,Activity> activities;
    private HashMap<String,Material> materials;

    private HashMap<String,int[]> inventoryOnHand;
    private static Service service=null;


    private ServiceImpl(int time){
        machines= new HashMap<>();
        activities= new HashMap<>();
        materials= new HashMap<>();
        inventoryOnHand = new HashMap<>();
        this.time=time;
    }

    public Service getInstance(int time) {
        if(service==null)
            service= new ServiceImpl(time);
        return service;
    };

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getProgramedReceptions(int timeIndex,Material material) {
        return 0;
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
    public int getNetRequirement(int timeIndex,Material material){
        int requirement=0;
        int inventory = getInventoryOnHand(timeIndex,material);
        if(inventory<=material.getSecurityStock()){
            requirement=material.getSecurityStock()-inventory;
        }
        return requirement;
    }

    @Override
    public int getInventoryOnHand(int timeIndex,Material material){
        int inventory=0;
        if (!inventoryOnHand.containsKey(material.getId())){
            inventoryOnHand.put(material.getId(),new int[time+1]);
            inventoryOnHand.get(material.getId())[0]=materials.get(material.getId()).getInitialInventoryOnHand();
        }
        if (timeIndex>0){
            inventory=inventoryOnHand.get(material.getId())[timeIndex-1]-getRequirementOfMaterial(timeIndex,material)+getProgramedReceptions(timeIndex,material);
        }
        inventoryOnHand.get(material.getId())[timeIndex]=inventory;
        return inventory;
    }
    @Override
    public void updateInventoryOnHand(int timeIndex, Material material, int plannedReceptions)throws MRPException{
        inventoryOnHand.get(material.getId())[timeIndex]+=plannedReceptions;
    }

    private int getRequirementOfActivity(String idActivity, int indexTime){
            int totalRequirement=0;
            HashMap<Machine,Integer> cantRequirement =activities.get(idActivity).getCalendar();
            for(Integer i:cantRequirement.values())
                if(i == indexTime)
                    totalRequirement+=1;
            return totalRequirement;
    }

    @Override
    public int getRequirementOfMaterial(int indexTime,Material material){
        int totalRequirement=0;
        for(Activity i:activities.values()){
            if(i.getMaterials().contains(material))
                totalRequirement+=getRequirementOfActivity(i.getId(),indexTime);
        }
        return totalRequirement;
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
