package com.coding.persistence.spring_jpa_mysql.models;

import com.coding.persistence.spring_jpa_mysql.models.Activity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

public class Machine {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String name;

    private ArrayList<Activity> activities;

    public Machine(String id, String name){
        this.id=id;
        this.name=name;
        activities=new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivity(Activity activity) {
        if(!activities.contains(activity))
            activities.add(activity);

    }

}
