package com.coding.mrpImplementation.dao;

import com.coding.mrpImplementation.entities.Activity;
import java.util.List;

public interface ActivityDAO {
    List<Activity> getActivities() throws PersistenceException;
    void addActivity(String idActivity,String name) throws PersistenceException;
    List<Integer> getCalendar(String idActivity) throws  PersistenceException;
    void addCalendar(String idActivity,int period)throws PersistenceException;
}
