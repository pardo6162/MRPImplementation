package com.coding.mrpImplementation.controller;


import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import com.coding.mrpImplementation.service.persistence.CompanyRepository;
import com.coding.mrpImplementation.service.persistence.MachineRepository;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.OptimizedAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/mrp")
public class MainController {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MachineRepository machineRepository;

    @PostMapping(path = "/company")
    public @ResponseBody String addCompany (@RequestBody Company company){
        companyRepository.save(company);
        return "Saved";
    }

    @GetMapping(path="/company/{nit}")
    public  @ResponseBody Company getCompany(@PathVariable(value="nit")String nit ){
        Company company=null;
        Optional<Company> optCompany= companyRepository.findById(nit);
        company=optCompany.get();
        return company;
    }


    @GetMapping(path="/company")
    public @ResponseBody List<Company> getCompanies(){
        return companyRepository.findAll();
    }


    @PostMapping(path="/company/{nit}/machine")
    public  @ResponseBody String addMachine (@PathVariable(value="nit")String nit,@RequestBody Machine machine){
        Company company=companyRepository.findById(nit).get();
        List<Machine> machines=company.getMachines();
        List<Company> companies=machine.getCompanies();
        companies.add(company);
        machines.add(machine);
        company.setMachines(machines);
        companyRepository.save(company);
        machine.setCompanies(companies);
        machineRepository.save(machine);
        return "Saved";
    }
}
