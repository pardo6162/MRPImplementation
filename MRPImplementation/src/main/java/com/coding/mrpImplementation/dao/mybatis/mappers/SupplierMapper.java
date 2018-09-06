package com.coding.mrpImplementation.dao.mybatis.mappers;

import com.coding.mrpImplementation.entities.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {
    List<Supplier> getSuppliers();
    void addSupplier(@Param("idSupplier") int id,@Param("businessName") String businessName,@Param("country") String country,@Param("address") String address,@Param("deliveryTime") int deliveryTime,@Param("phone") int phone) ;
}
