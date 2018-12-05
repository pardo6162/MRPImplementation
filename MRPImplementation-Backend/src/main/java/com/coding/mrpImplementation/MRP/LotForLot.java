package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;

public class LotForLot {/**implements MRP {
    @Override

    public int execute(Service service, Material material, int timeIndex, Company company) throws MRPException {
        int plannedReceptions = 0;
            int netRequirement = service.getNetRequirement(timeIndex, material);
            int sizeOfLot = material.getSizeOfLot();
            if (netRequirement % sizeOfLot == 0) {
                plannedReceptions =  sizeOfLot * ((netRequirement / sizeOfLot - (netRequirement % sizeOfLot) / sizeOfLot));
            } else {
                plannedReceptions = sizeOfLot * ((netRequirement / sizeOfLot) - ((netRequirement % sizeOfLot) / sizeOfLot) + 1);
            }
            if(plannedReceptions-netRequirement!=0){
                plannedReceptions=netRequirement-plannedReceptions;
            }
            service.updateInventoryOnHand(timeIndex, material, plannedReceptions);
        return plannedReceptions;

    }**/
}
