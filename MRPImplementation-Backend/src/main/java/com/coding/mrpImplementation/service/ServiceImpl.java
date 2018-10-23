package com.coding.mrpImplementation.service;

import com.coding.mrpImplementation.entities.Company;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.MRP.*;
import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.coding.mrpImplementation.entities.Material;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceImpl implements Service{

    private int time;
    private Company company;
    private HashMap<String,int[]> inventoryOnHand;
    private static Service service=null;
    private HashMap<String,int[]> programedReceptions;


    private ServiceImpl(Company company,int time){
        inventoryOnHand = new HashMap<>();
        programedReceptions = new HashMap<>();
        this.company=company;
        this.time =time;
    }


    /**
     * generate only one instance of Service class
     * **/
    public static Service getInstance(Company company,int time) {
        if(service==null)
            service= new ServiceImpl(company,time);
        return service;
    };

    @Override
    public void addProgramedReceptions( int timeIndex, Material material ,int quantity) {
        if(!programedReceptions.containsKey(material.getId())){
            int [] temp= new int[time];
            temp[timeIndex]= quantity;
            programedReceptions.put(material.getId(),temp);
        }
    }


    @Override
    public int getProgramedReceptions(int timeIndex,Material material) {
        int programedReception=0;
        if(programedReceptions.containsKey(material.getId())){
            programedReception=programedReceptions.get(material.getId())[timeIndex];
        }
        return programedReception;
    }
    @Override
    public int getTime(){
        return time;
    }


    @Override
    public HashMap<Material,int[]> planning(String lotMethod) throws MRPException {
        Object instance;
        HashMap<Material,int[]> resultHashMap=new HashMap<>();
        try {
            instance = Class.forName("com.coding.mrpImplementation.MRP." + lotMethod).newInstance();
            MRP methodInstance=(MRP) instance;
            for (Material j : company.getMaterials()) {
                int[] planingPeriods=new int[service.getTime()];
                for (int i = 0; i < service.getTime(); i++) {
                    planingPeriods[i]=methodInstance.execute(this,j,i,company);
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
            inventoryOnHand.put(material.getId(), new int[service.getTime()]);
            if(timeIndex==0)
                inventoryOnHand.get(material.getId())[timeIndex]=0;
                company.getMaterial(material.getId()).getInitialInventoryOnHand();
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
     * This method return the total times to that a programed activity in a specific index time
     * @param idActivity
     * @param indexTime
     * @return the count of times that the activity is make in a specific period of time
     * @throws MRPException
     */
    @Override
    public int getRequirementOfActivity(String idActivity, int indexTime)throws MRPException{
            int totalRequirement=0;
            HashMap<Machine,ArrayList<Integer>> cantRequirement =company.getActivity(idActivity).getCalendar();
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

        for(Activity i:company.getActivities()) {

            if (i.getMaterials().keySet().contains(material)) {
                totalRequirement += getRequirementOfActivity(i.getId(), indexTime) * i.getMaterials().get(material);
            }
        }

        return totalRequirement;
    }

    @Override
    public void resetInventoryOnHand() throws  MRPException{
        inventoryOnHand.clear();
    }

    @Override
    public void updateInventoryOnHand(int timeIndex, Material material, int plannedReceptions)throws MRPException{
        inventoryOnHand.get(material.getId())[timeIndex]+=plannedReceptions;
    }
}
