package com.coding.mrpImplementation.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Company {

    @Id
    private String nit;
    private String name;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "MachineOfCompanies",
            joinColumns = { @JoinColumn(name = "company_nit",referencedColumnName = "nit") },
            inverseJoinColumns = { @JoinColumn(name = "machine_id",referencedColumnName = "id") })
    private List<Machine>  machines;


    public Company(){

    }

    public Company( String nit, String name) {
        this.name = name;
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

}
