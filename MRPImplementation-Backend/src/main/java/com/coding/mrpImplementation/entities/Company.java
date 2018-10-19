package com.coding.mrpImplementation.entities;


import java.util.ArrayList;
import java.util.HashMap;

public class Company {

    private int time;
    private HashMap<String,int[]> programedReceptions;

    private ArrayList<Machine>  machines;

    public Company(int time){
        machines =new ArrayList<>();
        programedReceptions = new HashMap<>();
        this.time=time;
    }

    public void addMachine(Machine machine){
        if(machines.contains(machine))
            machines.add(machine);
    }

    public ArrayList<Machine> getMachines(){
        return machines;
    }

    public int getTime(){
        return time;
    }

    public void addProgramedReceptions( int timeIndex, Material material ,int quantity) {
        if(!programedReceptions.containsKey(material.getId())){
            int [] temp= new int[time];
            temp[timeIndex]= quantity;
            programedReceptions.put(material.getId(),temp);
        }
    }

    public int getProgramedReceptions(int timeIndex,Material material) {
        int programedReception=0;
        if(programedReceptions.containsKey(material.getId())){
            programedReception=programedReceptions.get(material.getId())[timeIndex];
        }
        return programedReception;
    }

    public HashMap<String,int[]> getProgramedReceptions(){
        return programedReceptions;
    }

    public  ArrayList<Material> getMaterials(){
        ArrayList<Material> materials= new ArrayList<>();
        for ( Machine i: machines)
            for (Activity j:i.getActivities())
                for (Material k:j.getMaterials().keySet())
                    materials.add(k);
        return materials;
    }

    public  Material getMaterial(Material material){
        ArrayList<Material> materials=new ArrayList<>();
        int index=materials.indexOf(material);
        return materials.get(index);
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
