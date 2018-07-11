package com.coding.mrpImplementation.MRP.lotMethods;

import com.coding.mrpImplementation.MRP.MRP;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;

public class LotForLot implements MRP {
    @Override
    public int execute(Service service, Material material, int time) throws MRPException {
        if(service.netRequirement(time,material.getId())%service.getSizeOfLot()==0){

        }
        return 0;
    }
}
