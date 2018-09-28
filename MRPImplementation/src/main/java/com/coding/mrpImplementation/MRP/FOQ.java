package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.MRP.MRP;
import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;

public class FOQ implements MRP {
    @Override
    public int execute(Service service, Material material, int timeIndex) throws MRPException {
        int netRequirement=service.getNetRequirement(timeIndex,material);
        int plannedReceptions= netRequirement;
        service.updateInventoryOnHand(timeIndex, material, plannedReceptions);
        return plannedReceptions;
    }
}
