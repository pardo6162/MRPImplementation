package com.coding.persistence.spring_jpa_mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface ActivityRepository extends CrudRepository<com.coding.persistence.spring_jpa_mysql.models.Activity,Integer> {



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
    
}