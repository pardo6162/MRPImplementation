package com.coding.mrpImplementation.entities;

import com.coding.mrpImplementation.entities.Activity;
import java.util.ArrayList;

public class Machine {
    private String id;
    private String name;

    private ArrayList<com.coding.mrpImplementation.entities.Activity> activities;

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

    public ArrayList<com.coding.mrpImplementation.entities.Activity> getActivities() {
        return activities;
    }

    public void setActivity(Activity activity) {
        if(!activities.contains(activity))
            activities.add(activity);

    }

}