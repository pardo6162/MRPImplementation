package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier,Integer> {
    Supplier save(Supplier supplier);
    List<Supplier> findAll();
    Supplier findById(String id);
    void delete(Supplier supplier);
}
