package com.coding.mrpImplementation.dao.mybatis.mappers;

import com.coding.mrpImplementation.dao.PersistenceException;
import com.coding.mrpImplementation.entities.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    List<Activity> getActivities() throws PersistenceException;
    void addActivity(@Param("idActivity") String idActivity, @Param("name") String name) throws PersistenceException;
    List<Integer> getCalendar(@Param("idActivity") String idMaterial) throws  PersistenceException;
    void addCalendar(@Param("idActivity") String idMaterial, @Param("period") int period)throws PersistenceException;
}
