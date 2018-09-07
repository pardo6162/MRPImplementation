package com.coding.mrpImplementation.dao.mybatis.mappers;

import com.coding.mrpImplementation.dao.PersistenceException;
import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MachineMapper {
    List<Machine> getMachines() throws PersistenceException;
    List<Activity> getActivities(@Param("idMachine")String idMachine) throws  PersistenceException;
    void addMachine(@Param("idMachine") String idMachine, @Param("name") String name) throws  PersistenceException;
    void addActivityToMachine(@Param("idActivity") String idActivity, @Param("idMachine") String idMachine) throws PersistenceException;

}
