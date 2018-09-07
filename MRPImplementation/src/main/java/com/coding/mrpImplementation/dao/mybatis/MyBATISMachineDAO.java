package com.coding.mrpImplementation.dao.mybatis;

import com.coding.mrpImplementation.dao.PersistenceException;
import com.coding.mrpImplementation.dao.mybatis.mappers.MachineMapper;
import com.coding.mrpImplementation.dao.mybatis.mappers.MaterialMapper;
import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import com.google.inject.Inject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class MyBATISMachineDAO {
    @Inject
    private MachineMapper machineMapper;

    public List<Machine> getMachines() throws PersistenceException{
        return machineMapper.getMachines();
    }

    public List<Activity> getActivities(String idMachine) throws  PersistenceException{
        return machineMapper.getActivities(idMachine);
    }

    void addMachine( String idMachine, String name) throws  PersistenceException{
        machineMapper.addMachine(idMachine,name);
    }
    void addActivityToMachine( String idActivity,String idMachine) throws PersistenceException{
        machineMapper.addActivityToMachine(idActivity,idMachine);
    }

}
