package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;

public class EOQ {/**} implements MRP {

    private int sumTotalRequirement=0;

    @Override
    public int execute(Service service, Material material, int timeIndex, Company company) throws MRPException {
        int plannedReceptions=0;
        int period =material.getPeriod();
        int time=company.getTime();
        int netRequirement=service.getNetRequirement(timeIndex,material);
        if(sumTotalRequirement==0)
            for (int i=0;i<time;i++){
                sumTotalRequirement+=service.getRequirementOfMaterial(i,material);
            }
        double factor=sumTotalRequirement/time;
        double innerTerm= (2*factor*material.getOrderingCost())/material.getMaintainCost();
        double square=Math.sqrt(innerTerm);
        if(netRequirement!=0){
            plannedReceptions=(int) Math.ceil(netRequirement/square);
            plannedReceptions*=square;
        }
        service.updateInventoryOnHand(timeIndex, material, plannedReceptions);
        return plannedReceptions;
    }**/
}
