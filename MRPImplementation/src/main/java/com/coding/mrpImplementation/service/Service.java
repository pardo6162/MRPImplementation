package com.coding.mrpImplementation.service;

import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;

import java.util.ArrayList;
import java.util.HashMap;

public interface Service {
    Service getInstance(int time) ;
    int getTime() throws MRPException;
    int getProgramedReceptions(int timeIndex,Material material)throws MRPException;
    int getRequirementOfMaterial(int indexTime,Material material)throws MRPException;
    void updateInventoryOnHand(int timeIndex, Material material,int plannedReceptions) throws MRPException;
    HashMap<Material,int[]> plaining(String lotMethod) throws MRPException;
    int getInventoryOnHand(int timeIndex,Material material) throws  MRPException;
    int getNetRequirement(int timeIndex,Material material) throws MRPException;
    void addMachine(Machine machine) throws MRPException;
    void addAcivityToMachine(String idActivity,String idMachine) throws MRPException;
    void addMaterialToActivity(String idMaterial,String idActivity) throws MRPException;
    ArrayList<Machine> getMachines() throws MRPException;
    ArrayList<Activity> getActivities() throws MRPException;
    ArrayList<Material> getMaterials() throws MRPException;
    void addMaterial(Material material) throws MRPException;
    void addActivity(Activity activity) throws MRPException;
}
