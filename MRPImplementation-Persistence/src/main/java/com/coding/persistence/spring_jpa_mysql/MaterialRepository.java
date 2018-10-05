package com.coding.persistence.spring_jpa_mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface MaterialRepository extends CrudRepository<com.coding.persistence.spring_jpa_mysql.models.Material,Integer>  {
}
