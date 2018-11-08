package com.coding.mrpImplementation.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table
public class Company {

    @Id
    private String id;

//private ArrayList<Machine>  machines;

    private int time;

    public Company(){
       // machines =new ArrayList<>();

    }
/**
    public void addMachine(Machine machine){
        if(!machines.contains(machine))
            machines.add(machine);
    }

    public ArrayList<Machine> getMachines(){
        return machines;
    }


    public  Machine getMachine(String  idMachine){
        Machine machine=null;
        for (Machine i:machines)
            if(i.getId().equals(idMachine))
                machine=i;
        return machine;
    }

  /**  public  ArrayList<Material> getMaterials(){
        ArrayList<Material> materials= new ArrayList<>();
        for ( Machine i: machines)
            for (Activity j:i.getActivities())
                for (Material k:j.getMaterials())
                    materials.add(k);
        return materials;
    }

    public  Material getMaterial(String materialId){
        Material material=null;
        for ( Machine i: machines)
            for (Activity j:i.getActivities())
                for (Material k:j.getMaterials())
                    if (materialId.equals(k.getId()))
                        material=k;
        return material;
    }

    public ArrayList<Activity> getActivities(){
        ArrayList<Activity> activities = new ArrayList<>();
        for ( Machine i: machines)
            for (Activity j:i.getActivities())
                activities.add(j);
        return activities;
    }

    public Activity getActivity(String idActivity){
        ArrayList<Activity> activities = new ArrayList<>();
        Activity activity=null;
        for ( Machine i: machines)
            for (Activity j:i.getActivities()){
                activities.add(j);
                if(idActivity == j.getId())
                    activity=j;
            }
        return  activity;
    }
 **/


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(int time){
        this.time=time;
    }


    public int getTime(){
        return time;
    }

}
