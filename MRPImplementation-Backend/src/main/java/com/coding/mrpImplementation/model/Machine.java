package com.coding.mrpImplementation.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Machine {

    @Id
    private String id;
    private String name;
   // private ArrayList<Activity> activities;

    public Machine(String id, String name){
        this.id=id;
        this.name=name;
        //activities=new ArrayList<>();
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

   /** public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }**/






}
