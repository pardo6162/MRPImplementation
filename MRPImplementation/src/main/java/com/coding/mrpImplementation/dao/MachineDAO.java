package com.coding.mrpImplementation.dao;

import com.coding.mrpImplementation.entities.Activity;
import com.coding.mrpImplementation.entities.Machine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface   MachineDAO {
    List<Machine> getMachines() throws PersistenceException;
    List<Activity> getActivities(String idMachine) throws  PersistenceException;
    void addMachine( String idMachine,String name) throws  PersistenceException;
    void addActivityToMachine( String idActivity,  String idMachine) throws PersistenceException;
}
