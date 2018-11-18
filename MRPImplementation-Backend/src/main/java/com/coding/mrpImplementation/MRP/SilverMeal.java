package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;

public class SilverMeal {/**implements MRP {
    @Override
    public int execute(Service service, Material material, int timeIndex, Company company) throws MRPException {
        int plannedReceptions=0;
        int netRequirement =service.getNetRequirement(timeIndex,material);
        int time=company.getTime();
        int requirement=0;
        int[][] inventory=new int[time][2];
        int requirementOfMaterial=service.getRequirementOfMaterial(timeIndex+1,material);
        int maintainCost=material.getMaintainCost();
        int orderingCost=material.getOrderingCost();
        int requirementInventary=0;
        int costInventory=0;
        int valorComp=0;
        int unitaryCost=0;
        int contPeriod=0;
        if(netRequirement!=0) {
            for (int i = 0; i < time - 1; i++) {
                contPeriod++;
                requirement += service.getRequirementOfMaterial(i + 1, material);
                requirementInventary += (requirementOfMaterial * i);
                costInventory = maintainCost * requirementInventary;
                valorComp = costInventory + orderingCost;
                unitaryCost = valorComp / contPeriod;
                inventory[i][0] = unitaryCost;
                inventory[i][1] = requirement;
            }
            int i = 0,index =0;
            boolean exit=false;
            int value= inventory[0][0];
            int inventoryValue=0;

            while ((valorComp != 0 && !exit)&& i<time-1) {
                if (value < inventory[index+1][0] && (i==0 || inventory[index][0]>=value)) {
                    inventoryValue=inventory[index][1];
                    exit=true;
                }
                index++;
                i++;
                value=inventory[index][0];
                plannedReceptions=inventoryValue;

            }
        }
        service.updateInventoryOnHand(timeIndex, material, plannedReceptions);
        return plannedReceptions;
    }**/

}
