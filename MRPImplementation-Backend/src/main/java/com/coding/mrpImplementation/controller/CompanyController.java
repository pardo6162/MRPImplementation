package com.coding.mrpImplementation.controller;

import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class CompanyController {

    @Controller
    @RequestMapping(path="/mrp")
    public class MainController {
        @Autowired
        private ActivityRepository activityRepository;

        @GetMapping(path = "/company")
        public @ResponseBody String addCompany(){


            return "Saved";
        }
    }
}
