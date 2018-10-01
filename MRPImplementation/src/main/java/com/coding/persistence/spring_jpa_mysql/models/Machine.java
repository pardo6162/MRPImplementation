package com.coding.persistence.spring_jpa_mysql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String name;

    private ArrayList<com.coding.persistence.spring_jpa_mysql.models.Activity> activities;

    public Machine(){

    }



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

    public ArrayList<com.coding.persistence.spring_jpa_mysql.models.Activity> getActivities() {
        return activities;
    }

    public void setActivity(com.coding.persistence.spring_jpa_mysql.models.Activity activity) {
        if(!activities.contains(activity))
            activities.add(activity);

    }

}
