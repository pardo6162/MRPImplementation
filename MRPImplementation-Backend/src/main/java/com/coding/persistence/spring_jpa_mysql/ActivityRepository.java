package com.coding.persistence.spring_jpa_mysql;

import com.coding.persistence.spring_jpa_mysql.models.ActivityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface ActivityRepository extends CrudRepository<ActivityEntity,Integer> {



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
    
}