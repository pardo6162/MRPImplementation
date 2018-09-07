package com.coding.mrpImplementation.dao.mybatis;

import com.coding.mrpImplementation.dao.PersistenceException;
import com.coding.mrpImplementation.dao.mybatis.mappers.ActivityMapper;
import com.coding.mrpImplementation.entities.Activity;
import org.apache.ibatis.annotations.Param;

import javax.inject.Inject;
import java.util.List;

public class MyBATISActivityDAO {

    @Inject
    ActivityMapper activityMapper;

    List<Activity> getActivities() throws PersistenceException{
        return activityMapper.getActivities();
    }
    void addActivity(String idActivity,String name) throws PersistenceException{
        activityMapper.addActivity(idActivity,name);
    }

    List<Integer> getCalendar(String idActivity) throws  PersistenceException{
        return activityMapper.getCalendar(idActivity);
    }

    void addCalendar(String idActivity,int period)throws PersistenceException{
        activityMapper.addCalendar(idActivity,period);
    }
}
