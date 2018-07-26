package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.MRP.MRP;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;

public class LotForLot implements MRP {
    @Override

    public int execute(Service service, Material material, int timeIndex) throws MRPException {
        int plannedReceptions=0;
        int netRequirement= service.getNetRequirement(timeIndex,material);
        System.out.printf("netRequirement %d timeIndex %d%n",netRequirement,timeIndex);
        int sizeOfLot=material.getSizeOfLot();
        if(netRequirement%sizeOfLot==0){
            plannedReceptions=netRequirement;
        }else{
            System.out.println("entraaaa else");
            plannedReceptions= sizeOfLot*((netRequirement/sizeOfLot) - ((netRequirement%sizeOfLot)/sizeOfLot)+1);
        }
        System.out.printf("prev inventory %d%n",service.getInventoryOnHand(timeIndex,material));
        service.updateInventoryOnHand(timeIndex,material,plannedReceptions);
        System.out.printf("post inventoryOnHand %d%n",service.getInventoryOnHand(timeIndex,material));
        return plannedReceptions;
    }
}
