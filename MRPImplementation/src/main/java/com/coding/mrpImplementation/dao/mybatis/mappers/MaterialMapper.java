package com.coding.mrpImplementation.dao.mybatis.mappers;

import com.coding.mrpImplementation.dao.PersistenceException;
import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {
    List<Material> getMaterials() throws PersistenceException;
    List<Activity> getActivitiesOfMaterial(@Param("idMaterial") String idMaterial) throws  PersistenceException;
    void addMaterial (@Param("idMaterial") String idMaterial,@Param("name") String name,@Param("initialInventoryOnHand") int initialInventoryOnHand,@Param("oderingCost") int orderingCost,@Param("maintainCost") int maintainCost,@Param("securityStock") int securityStock,@Param("sizeOfLot") int sizeOfLot,@Param("availablePrev") int availablePrev,@Param("period") int period)throws PersistenceException;
}
