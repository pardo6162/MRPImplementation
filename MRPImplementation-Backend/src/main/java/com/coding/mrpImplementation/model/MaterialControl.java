package com.coding.mrpImplementation.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MaterialControl {
    private String id;
    private int date;
    private int quantity;
    private int securityStock;
    private int sizeOfLot;
    @ManyToOne
    @JoinColumn(name="company_nit")
    private Company company;


    public MaterialControl() {}

    public MaterialControl(String id, int date, int quantity, int securityStock, int sizeOfLot, Company company) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.securityStock = securityStock;
        this.sizeOfLot = sizeOfLot;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSecurityStock() {
        return securityStock;
    }

    public void setSecurityStock(int securityStock) {
        this.securityStock = securityStock;
    }

    public int getSizeOfLot() {
        return sizeOfLot;
    }

    public void setSizeOfLot(int sizeOfLot) {
        this.sizeOfLot = sizeOfLot;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
