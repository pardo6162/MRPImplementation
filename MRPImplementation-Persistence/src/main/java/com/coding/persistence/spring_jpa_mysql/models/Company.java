package com.coding.persistence.spring_jpa_mysql.models;

import java.util.ArrayList;

public class Company {
    private ArrayList<Machine> machines;

    public ArrayList<Machine> getMachines() {
        return machines;
    }

    public void setMachines(ArrayList<Machine> machines) {
        this.machines = machines;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    private int time;


}
