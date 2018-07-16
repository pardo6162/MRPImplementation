package com.coding.mrpImplementation.MRP.lotMethods;

import com.coding.mrpImplementation.MRP.MRP;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;

public class LotForLot implements MRP {
    @Override

    public int execute(Service service, Material material, int time) throws MRPException {
        int plannedReceptions=0;
        int netRequirement= service.getNetRequirement()(time,material.getId());
        int sizeOfLot=service.getSizeOfLot();
        if(netRequirement%sizeOfLot==0){
            plannedReceptions=netRequirement;
        }else{
            plannedReceptions= sizeOfLot*((netRequirement/sizeOfLot) - ((netRequirement%sizeOfLot)/sizeOfLot)+1);
        }
        return plannedReceptions;
    }
}
