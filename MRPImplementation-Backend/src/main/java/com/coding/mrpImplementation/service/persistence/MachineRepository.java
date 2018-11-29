package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Machine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MachineRepository extends CrudRepository<Machine,String> {
    Machine save(Machine machine);

    void delete(Machine machine);

    List<Machine> findAll();

}
