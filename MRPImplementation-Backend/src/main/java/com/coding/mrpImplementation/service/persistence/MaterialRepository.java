package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaterialRepository extends CrudRepository<Material,Integer> {
    Material save(Material material);
    List<Material> findAll();
    Material findById(String idMaterial);
    void delete(Material material);
}
