package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineRepository extends CrudRepository<Machine,String> {
    Machine save(Machine machine);
}
