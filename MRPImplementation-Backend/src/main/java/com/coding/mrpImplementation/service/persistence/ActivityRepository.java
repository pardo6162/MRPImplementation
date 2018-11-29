package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity,Integer> {
    Activity findById(String id);
    String save(Activity activity);
    void delete(Activity activity);
}
