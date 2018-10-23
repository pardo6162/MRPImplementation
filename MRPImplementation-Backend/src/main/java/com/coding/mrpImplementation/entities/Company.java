package com.coding.mrpImplementation.entities;


import java.util.ArrayList;
import java.util.HashMap;

public class Company {




    private ArrayList<Machine>  machines;

    public Company(){
        machines =new ArrayList<>();

    }

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

    public  ArrayList<Material> getMaterials(){
        ArrayList<Material> materials= new ArrayList<>();
        for ( Machine i: machines)
            for (Activity j:i.getActivities())
                for (Material k:j.getMaterials().keySet())
                    materials.add(k);
        return materials;
    }

    public  Material getMaterial(String materialId){
        Material material=null;
        for ( Machine i: machines)
            for (Activity j:i.getActivities())
                for (Material k:j.getMaterials().keySet())
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

}
