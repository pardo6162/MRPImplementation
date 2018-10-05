package com.coding.persistence.spring_jpa_mysql;

import com.coding.persistence.spring_jpa_mysql.models.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity,Integer> {



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
    
}