package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier,Integer> {
}
