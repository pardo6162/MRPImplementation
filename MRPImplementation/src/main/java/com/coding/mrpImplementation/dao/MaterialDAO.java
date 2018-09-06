package com.coding.mrpImplementation.dao;

import com.coding.mrpImplementation.dao.mybatis.mappers.MaterialMapper;
import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Material;
import com.google.inject.Inject;

import java.util.List;

public interface  MaterialDAO {
    public List<Material> getMaterials() throws PersistenceException;
    public List<Activity> getActivitiesOfMaterial(String idMaterial) throws  PersistenceException;
    public void addMaterial (String idMaterial, String name, int initialInventoryOnHand,int orderingCost,  int maintainCost, int securityStock,  int sizeOfLot, int availablePrev,int period)throws PersistenceException;
}
