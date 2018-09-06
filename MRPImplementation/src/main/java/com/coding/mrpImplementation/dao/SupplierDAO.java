package com.coding.mrpImplementation.dao;

import com.coding.mrpImplementation.entities.Supplier;

import java.util.List;

public interface SupplierDAO {
    List<Supplier>  getSuppliers() throws PersistenceException;
    void addSupplier(int id, String businessName,String country,String address,int deliveryTime, int phone) throws  PersistenceException;
}
