package com.coding;


import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class Application {
    @Autowired
    private  ActivityRepository activityRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
