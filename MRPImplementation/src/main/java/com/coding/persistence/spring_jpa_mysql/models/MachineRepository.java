package com.coding.persistence.spring_jpa_mysql;

import org.springframework.data.repository.CrudRepository;

public interface MachineRepository  extends CrudRepository<com.coding.persistence.spring_jpa_mysql.models.Machine,Integer>  {
}
