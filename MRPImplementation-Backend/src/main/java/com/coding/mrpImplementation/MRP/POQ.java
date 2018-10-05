package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.MRP.MRP;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;

public class POQ implements MRP {


    @Override
    public int execute(Service service, Material material, int timeIndex) throws MRPException {
        int plannedReceptions=0;
        int period =material.getPeriod();
        int time=service.getTime();
        int netRequirement=service.getNetRequirement(timeIndex,material);
        int sumProgramedReceptions=0;
        int sumTotalRequirement=0;
        int sumRequirement=0;

        if(sumTotalRequirement==0)
            for (int i=0;i<time;i++){
                sumTotalRequirement+=service.getRequirementOfMaterial(i,material);
            }
        int factor=sumRequirement/time;
        int innerTerm= (2*factor*material.getOrderingCost())/material.getMaintainCost();
        int square=(int)Math.sqrt(innerTerm);
        if(netRequirement!=0){
            for (int i=0;i<period+1;i++){
                sumRequirement+=service.getRequirementOfMaterial(i,material);
                sumProgramedReceptions+=service.getProgramedReceptions(i,material);
            }
            int inventoryOnHand=0;
            if(inventoryOnHand==0)
                service.getInventoryOnHand(timeIndex,material);
            else
                service.getInventoryOnHand(timeIndex-1,material);
            plannedReceptions=sumRequirement - sumProgramedReceptions - inventoryOnHand-material.getSecurityStock()+square;
        }
        service.updateInventoryOnHand(timeIndex, material, plannedReceptions);
        return plannedReceptions;
    }
}
