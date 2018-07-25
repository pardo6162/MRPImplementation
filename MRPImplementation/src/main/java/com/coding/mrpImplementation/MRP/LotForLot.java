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
        int sizeOfLot=material.getSizeOfLot();
        if(netRequirement%sizeOfLot==0){
            plannedReceptions=netRequirement;
        }else{
            plannedReceptions= sizeOfLot*((netRequirement/sizeOfLot) - ((netRequirement%sizeOfLot)/sizeOfLot)+1);
        }
        service.updateInventoryOnHand(timeIndex,material,plannedReceptions);
        return plannedReceptions;
    }
}
