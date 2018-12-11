package com.coding.mrpImplementation.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class Supplier {
    @Id
    private String id;
    private String businessName;
    private String country;
    private String address;
    private int deliveryTime;
    private int phone;
    @OneToMany(cascade= {CascadeType.MERGE,CascadeType.REMOVE })
    @JoinTable(name = "SuppliersOfMaterial",
            joinColumns = { @JoinColumn(name = "supplier_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "material_id",referencedColumnName = "id") })
    private List<Material> materials;

    public Supplier(){}


    public Supplier(String id,String businessName,String country,String address,int deliveryTime, int phone){
        this.id = id;
        this.businessName=businessName;
        this.country=country;
        this.address=address;
        this.deliveryTime=deliveryTime;
        this.phone=phone;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
