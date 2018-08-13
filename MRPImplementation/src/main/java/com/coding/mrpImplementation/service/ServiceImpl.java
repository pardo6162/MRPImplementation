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
    private HashMap<String,int[]> programedReceptions;
    private static Service service=null;


    private ServiceImpl(int time){
        machines= new HashMap<>();
        activities= new HashMap<>();
        materials= new HashMap<>();
        inventoryOnHand = new HashMap<>();
        this.time=time;
    }


    /**
     * generate only one instance of Service class
     * **/
    public static Service getInstance(int time) {
        if(service==null)
            service= new ServiceImpl(time);
        return service;
    };

    /**
     * This method return the global time defined
     * @return int number of periods in evaluation
     */
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * This method add a new programed reception of material in specific time 
     * @param timeIndex
     * @param material
     * @param quantity
     * @throws MRPException
     */

    public void addProgramedReception(int timeIndex,Material material,int quantity) throws MRPException{
        if(!programedReceptions.containsKey(material.getId())){
            int [] temp= new int[time];
            temp[timeIndex]= quantity;
            programedReceptions.put(material.getId(),temp);
        }
    }

    /**
     * This method return de programed receptions of a material in a given time
     * @param timeIndex index of period
     * @param material  material in evaluation
     * @return 0
     */
    public int getProgramedReceptions(int timeIndex,Material material) {
        int programedReception=0;
        if(programedReceptions.containsKey(material.getId())){
            programedReception=programedReceptions.get(material.getId())[timeIndex];
        }
        return programedReception;
    }


    @Override
    public HashMap<Material,int[]> planning(String lotMethod) throws MRPException {
        Object instance;
        HashMap<Material,int[]> resultHashMap=new HashMap<>();
        try {
            instance = Class.forName("com.coding.mrpImplementation.MRP." + lotMethod).newInstance();
            MRP methodInstance=(MRP) instance;
            for (Material j : materials.values()) {
                int[] planingPeriods=new int[time];
                for (int i = 0; i < time; i++) {
                    planingPeriods[i]=methodInstance.execute(this,j,i);
                }
                resultHashMap.put(j,planingPeriods);
            }
        }catch(Exception ex){
            throw new MRPException(ex);
        }

        return resultHashMap;
    }


    /**
     * This method return the net requirement of specific material in a determinated period time
     * @param timeIndex
     * @param material
     * @return the quantity  net requeriment of material in the period time
     * @throws MRPException
     */
    @Override
    public int getNetRequirement(int timeIndex,Material material) throws MRPException{
        int requirement=0;
        int inventory = getInventoryOnHand(timeIndex,material);
        int securityStock=material.getSecurityStock();
        if(inventory<=securityStock){
            requirement=material.getSecurityStock()-inventory;
        }
        return requirement;
    }



    /**
     * This method return the inventory on hand in a specific time period for a material
     * @param timeIndex
     * @param material
     * @return int the quantity of material in the time
     */

    @Override
    public int getInventoryOnHand(int timeIndex,Material material) throws MRPException{
        int inventory=0;
        int prev;
        int requirementOfMaterial;
        int programedReception;
        if(!inventoryOnHand.containsKey(material.getId())){
            inventoryOnHand.put(material.getId(), new int[time]);
            if(timeIndex==0)
                inventoryOnHand.get(material.getId())[timeIndex]=0;materials.get(material.getId()).getInitialInventoryOnHand();
        }else if(inventoryOnHand.get(material.getId())[timeIndex]==0) {
            requirementOfMaterial = service.getRequirementOfMaterial(timeIndex, material);
            programedReception = service.getProgramedReceptions(timeIndex, material);
            if (timeIndex == 0)
                prev = inventoryOnHand.get((material.getId()))[timeIndex];
            else {
                prev = inventoryOnHand.get(material.getId())[timeIndex - 1];
            }
            inventoryOnHand.get(material.getId())[timeIndex] = prev - requirementOfMaterial + programedReception;
        }
        inventory=inventoryOnHand.get(material.getId())[timeIndex];
        return inventory;
    }

    /**
     * This method allow to update the inventory on hand when the planned receptions has been calculated
     * @param timeIndex
     * @param material
     * @param plannedReceptions
     * @throws MRPException
     */

    @Override
    public void updateInventoryOnHand(int timeIndex, Material material, int plannedReceptions)throws MRPException{
        inventoryOnHand.get(material.getId())[timeIndex]+=plannedReceptions;
    }


    /**
     * This method return the total times to that a programed activity in a specific index time
     * @param idActivity
     * @param indexTime
     * @return the count of times that the activity is make in a specific period of time
     * @throws MRPException
     */
    @Override
    public int getRequirementOfActivity(String idActivity, int indexTime)throws MRPException{
            int totalRequirement=0;
            HashMap<Machine,ArrayList<Integer>> cantRequirement =activities.get(idActivity).getCalendar();
            for(ArrayList<Integer> i:cantRequirement.values())
                for(Integer j:i){
                    if(j == indexTime)
                        totalRequirement+=1;
                }
            return totalRequirement;
    }

    /**
     * This method provide a requirement of material in a specific time period
     * @param indexTime
     * @param material
     * @return int the quantity of material required
     */
    @Override
    public int getRequirementOfMaterial(int indexTime,Material material) throws MRPException{
        int totalRequirement=0;

        for(Activity i:activities.values()) {

            if (i.getMaterials().keySet().contains(material)) {
                totalRequirement += getRequirementOfActivity(i.getId(), indexTime) * i.getMaterials().get(material);
            }
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
                activities.get(idActivity).setMachines(machines.get(idMachine));
            }
        }
    }

    @Override
    public void addMaterialToActivity(String idMaterial, String idActivity,int quantity) throws MRPException {
        if(activities.containsKey(idActivity)){

            if(materials.containsKey(idMaterial)){

                activities.get(idActivity).setMaterial(materials.get(idMaterial),quantity);
                materials.get(idMaterial).setActivity(activities.get(idActivity));
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

    @Override
    public void updateActivity(String activityId,Activity activity)throws  MRPException{
        if(activities.containsKey(activityId)){
            activities.remove(activityId);
            activities.put(activityId,activity);
        }
    }

    @Override
    public void resetInventoryOnHand() throws  MRPException{
        inventoryOnHand.clear();
    }
}
