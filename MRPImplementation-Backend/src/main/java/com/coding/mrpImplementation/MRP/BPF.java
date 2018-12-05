package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;

public class BPF{/** implements MRP {
    @Override
    public int execute(Service service, Material material, int timeIndex, Company company) throws MRPException {
        int plannedReceptions=0;
        int netRequirement =service.getNetRequirement(timeIndex,material);
        int time=company.getTime();
        int requirement;
        int[][] inventory=new int[time][2];
        int requirementOfMaterial=service.getRequirementOfMaterial(timeIndex+1,material);
        int maintainCost=material.getMaintainCost();
        int orderingCost=material.getOrderingCost();
        int requirementInventary;
        int costInventory=0;
        int valorComp=0;
        requirementInventary=0;
        for (int i = 0; i < time ; i++) {
            requirement=0;
            for(int j=i;j< time-1;j++){
                requirement += service.getRequirementOfMaterial(j, material);
            }
            requirementInventary += (requirementOfMaterial * i);
            costInventory = orderingCost * requirementInventary;
            valorComp = Math.abs(costInventory - maintainCost);
            inventory[i][0] = valorComp;
            inventory[i][1] = requirement;
        }
        int index =0;
        boolean exit=false;
        int value= inventory[0][0];

        int inventoryValue=0;
        inventoryValue=inventory[timeIndex][1]-service.getRequirementOfMaterial(timeIndex,material);

        while ((valorComp != 0 && !exit )&& index< time-1) {
            if ((inventory[index][0]>=value )&&(inventory[index+1][0])>value) {
                inventoryValue=inventory[index][1];
                        exit=true;
                }
                index++;
                value=inventory[index][0];
                plannedReceptions=inventoryValue;
        }
        service.updateInventoryOnHand(timeIndex, material, plannedReceptions);
        return plannedReceptions;
    }**/


}
