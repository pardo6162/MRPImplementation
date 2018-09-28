package com.coding.persistence.spring_jpa_mysql.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Supplier {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String businessName;
    private String country;
    private String address;
    private int deliveryTime;
    private int phone;


    public Supplier(String businessName,String country,String address,int deliveryTime, int phone, String id){
        this.businessName=businessName;
        this.country=country;
        this.address=address;
        this.deliveryTime=deliveryTime;
        this.phone=phone;
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



}
