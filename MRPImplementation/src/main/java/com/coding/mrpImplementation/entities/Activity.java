package com.coding.mrpImplementation.entities;

import java.util.ArrayList;

public class Activity {
    private String id;
    private String name;
    private ArrayList<Material> materials;

    public Activity(String id, String name){
        this.id=id;
        this.name=name;
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

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterial (Material material) {
        if(!materials.contains(material))
            materials.add(material);
    }
}
