package com.coding.persistence.spring_jpa_mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface SupplierRepository  extends CrudRepository<com.coding.persistence.spring_jpa_mysql.models.Supplier,Integer> {
}
