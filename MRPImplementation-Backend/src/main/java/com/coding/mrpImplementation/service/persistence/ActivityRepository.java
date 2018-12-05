package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Activity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ActivityRepository extends CrudRepository<Activity,Integer> {
    Optional<Activity> findById(String id);
    Activity save(Activity activity);
    void delete(Activity activity);
}
