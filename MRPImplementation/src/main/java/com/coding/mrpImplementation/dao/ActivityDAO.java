package com.coding.mrpImplementation.dao;

import com.coding.mrpImplementation.entities.Activity;
import java.util.List;

public interface ActivityDAO {
    List<Activity> getActivities() throws PersistenceException;
    void addActivity() throws  PersistenceException;
}
