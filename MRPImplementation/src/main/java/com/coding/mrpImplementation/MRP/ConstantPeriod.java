package com.coding.mrpImplementation.MRP.lotMethods;

import com.coding.mrpImplementation.MRP.MRP;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;

public class ConstantPeriod implements MRP {
    @Override
    public int execute(Service service, Material material, int timeIndex) throws MRPException {
        int plannedReceptions=0;
        int netRequirement= service.getNetRequirement(timeIndex,material);
        int sizeOfLot=material.getSizeOfLot();
        int sumRequirement=0;
        int sumProgramedReceptions=0;
        int period = material.getPeriod();
        if(netRequirement!=0){
            for (int i=0;i<period+1;i++){
                sumRequirement+=service.getRequirementOfMaterial(i,material);
                sumProgramedReceptions+=service.getProgramedReceptions(i,material);
            }
            plannedReceptions=sumRequirement - sumProgramedReceptions - service.getInventoryOnHand(timeIndex-1,material)-material.getSecurityStock();
        }
        return plannedReceptions;
    }
}
