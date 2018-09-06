package com.coding.mrpImplementation.dao.mybatis;

import com.coding.mrpImplementation.dao.PersistenceException;
import com.coding.mrpImplementation.dao.mybatis.mappers.MaterialMapper;
import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Material;
import com.google.inject.Inject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class MyBATISMaterialDAO {

    @Inject
    private MaterialMapper materialMapper;


    public List<Material> getMaterials() throws PersistenceException{
        return materialMapper.getMaterials();
    }
    public List<Activity> getActivitiesOfMaterial(String idMaterial) throws  PersistenceException{
        return materialMapper.getActivitiesOfMaterial(idMaterial);
    }
    public void addMaterial (String idMaterial, String name, int initialInventoryOnHand,int orderingCost,  int maintainCost, int securityStock,  int sizeOfLot, int availablePrev,int period)throws PersistenceException{
        materialMapper.addMaterial(idMaterial,name,initialInventoryOnHand,orderingCost,maintainCost,securityStock,sizeOfLot,availablePrev,period);
    }
}
