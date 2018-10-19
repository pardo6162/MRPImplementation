package com.coding.mrpImplementation.service;

import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;

import java.util.ArrayList;
import java.util.HashMap;

public interface Service {
    HashMap<Material,int[]> planning(String lotMethod) throws MRPException;
    int getNetRequirement(int timeIndex,Material material) throws MRPException;
    int getRequirementOfMaterial(int indexTime,Material material)throws MRPException;
    int getRequirementOfActivity(String idActivity, int indexTime)throws MRPException;
    int getInventoryOnHand(int timeIndex,Material material) throws  MRPException;
    void resetInventoryOnHand() throws  MRPException;
    void updateInventoryOnHand(int timeIndex, Material material, int plannedReceptions)throws MRPException;
}
