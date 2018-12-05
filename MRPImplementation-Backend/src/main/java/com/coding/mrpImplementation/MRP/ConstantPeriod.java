package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;

public class ConstantPeriod {/**implements MRP {
    @Override
    public int execute(Service service, Material material, int timeIndex, Company company) throws MRPException {
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
            int inventoryOnHand=0;
            if(timeIndex==0)
                inventoryOnHand=service.getInventoryOnHand(timeIndex,material);
            else
                inventoryOnHand=service.getInventoryOnHand(timeIndex-1,material);
            plannedReceptions=sumRequirement - sumProgramedReceptions - inventoryOnHand -material.getSecurityStock();
        }
        return plannedReceptions;
    }**/
}
