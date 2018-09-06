package com.coding.mrpImplementation.dao.mybatis;

import com.coding.mrpImplementation.dao.PersistenceException;
import com.coding.mrpImplementation.entities.Supplier;
import com.google.inject.Inject;
import com.coding.mrpImplementation.dao.SupplierDAO;
import com.coding.mrpImplementation.dao.mybatis.mappers.SupplierMapper;

import java.util.List;

public class MyBATISSupplierDAO  implements SupplierDAO {

    @Inject
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> getSuppliers() throws PersistenceException {
        return supplierMapper.getSuppliers();
    }
    @Override
    public void addSupplier(int id, String businessName,String country,String address,int deliveryTime, int phone) throws  PersistenceException {
        supplierMapper.addSupplier(id, businessName, country, address, deliveryTime, phone);
    }
}
