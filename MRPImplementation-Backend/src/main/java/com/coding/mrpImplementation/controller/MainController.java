package com.coding.mrpImplementation.controller;


import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import com.coding.mrpImplementation.service.persistence.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

@Controller
@RequestMapping(path="/mrp")
public class MainController {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping(path = "/company")
    public @ResponseBody String addCompany (@RequestParam String nit,@RequestParam String name){
        Company company=new Company(nit,name);
        companyRepository.save(company);
        return "Saved";
    }


}
