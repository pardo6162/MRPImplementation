package com.coding.mrpImplementation.service.impl;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.MRP.*;
import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ServiceImpl {//implements Service {

    private int time;
    private Company company;
    private static Service service=null;


   /** private ServiceImpl(Company company) throws  MRPException
    {
        try {
            this.company=company;
        }catch (Exception ex) {
            throw new MRPException(ex.getMessage());
        }

    }
**/

    /**
     * generate only one instance of Service class
     * **//**
    public static Service getInstance(Company company) throws  MRPException{
        if(service==null)
            service= new ServiceImpl(company);
        return service;
    };

    @Override
    public void addProgramedReceptions( int timeIndex, Material material ,int quantity) {
        Material materialInstance=company.getMaterial(material.getId());
        int [] temp= material.getProgramedReceptions();
        temp[timeIndex]= quantity;
        materialInstance.setProgramedReceptions(temp);
    }


    @Override
    public int getProgramedReceptions(int timeIndex,Material material) {
        Material materialInstance=company.getMaterial(material.getId());
         return material.getProgramedReceptions()[timeIndex];
    }


    @Override
    public HashMap<Material,int[]> planning(String lotMethod) throws MRPException {
        Object instance;
        HashMap<Material,int[]> resultHashMap=new HashMap<>();
        try {
            instance = Class.forName("com.coding.mrpImplementation.MRP." + lotMethod).newInstance();
            MRP methodInstance=(MRP) instance;
            for (Material j : company.getMaterials()) {
                int[] planingPeriods=new int[company.getTime()];
                for (int i = 0; i < company.getTime(); i++) {
                    planingPeriods[i]=methodInstance.execute(this,j,i,company);
                }
                resultHashMap.put(j,planingPeriods);
            }
        }catch(Exception ex){
            throw new MRPException(ex);
        }

        return resultHashMap;
    }

**/
    /**
     * This method return the net requirement of specific material in a determinated period time
     * @param timeIndex
     * @param material
     * @return the quantity  net requeriment of material in the period time
     * @throws MRPException
     *//**
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
**/


    /**
     * This method return the inventory on hand in a specific time period for a material
     * @param timeIndex
     * @param material
     * @return int the quantity of material in the time
     */
/**
    @Override
    public int getInventoryOnHand(int timeIndex,Material material) throws MRPException{
        int inventory=0;
        int prev;
        int requirementOfMaterial;
        int programedReception;
        Material materialInstance=company.getMaterial(material.getId());
        if(materialInstance.getInventoryOnHand()==null){
            materialInstance.setProgramedReceptions(new int[company.getTime()]);
            if(timeIndex==0){
                int [] temp=materialInstance.getInventoryOnHand();
                temp[timeIndex]=0;
                materialInstance.setProgramedReceptions(temp);
            }
        }else if(materialInstance.getInventoryOnHand()[timeIndex]==0) {
            requirementOfMaterial = service.getRequirementOfMaterial(timeIndex, material);
            programedReception = service.getProgramedReceptions(timeIndex, material);
            if (timeIndex == 0)
                prev = materialInstance.getInventoryOnHand()[timeIndex];
            else {
                prev = materialInstance.getInventoryOnHand()[timeIndex - 1];
            }
            int [] temp=materialInstance.getInventoryOnHand();
            temp[timeIndex] = prev - requirementOfMaterial + programedReception;
            materialInstance.setProgramedReceptions(temp);
        }
        inventory=materialInstance.getInventoryOnHand()[timeIndex];
        return inventory;
    }

**/

    /**
     * This method return the total times to that a programed activity in a specific index time
     * @param idActivity
     * @param indexTime
     * @return the count of times that the activity is make in a specific period of time
     * @throws MRPException
     */
/**    @Override
    public int getRequirementOfActivity(String idActivity, int indexTime)throws MRPException{
            int totalRequirement=0;
            Collection<ArrayList<Integer>> cantRequirement =company.getActivity(idActivity).getCalendar().values();
            for(ArrayList<Integer> i:cantRequirement)
                for(Integer j:i){
                    if(j == indexTime)
                        totalRequirement+=1;
                }
            return totalRequirement;
    }
**/
    /**
     * This method provide a requirement of material in a specific time period
     * @param indexTime
     * @param material
     * @return int the quantity of material required
     */
    /**@Override
    public int getRequirementOfMaterial(int indexTime,Material material) throws MRPException{
        int totalRequirement=0;

        for(Activity i:company.getActivities()) {

            if (i.getMaterials().contains(material)) {
                totalRequirement += getRequirementOfActivity(i.getId(), indexTime) * i.getMaterials().get(i.getMaterials().indexOf(material)).getQuantity().get(i);
            }
        }

        return totalRequirement;
    }


    @Override
    public void updateInventoryOnHand(int timeIndex, Material material, int plannedReceptions)throws MRPException{
        int[] inventoryOnHand= material.getInventoryOnHand();
        inventoryOnHand[timeIndex]+=plannedReceptions;
        company.getMaterial(material.getId()).setInventoryOnHand(inventoryOnHand);
    }
    ***/
}
