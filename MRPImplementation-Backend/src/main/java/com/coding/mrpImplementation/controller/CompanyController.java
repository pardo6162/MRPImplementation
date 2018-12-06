package com.coding.mrpImplementation.controller;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import com.coding.mrpImplementation.service.persistence.CompanyRepository;
import com.coding.mrpImplementation.service.persistence.MachineRepository;
import com.coding.mrpImplementation.service.persistence.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/mrp")
public class CompanyController extends MRPController{


    @PostMapping(path = "/company")
    public @ResponseBody
    String addCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return "Saved";
    }

    @GetMapping(path = "/company/{nit}")
    public @ResponseBody
    Company getCompany(@PathVariable(value = "nit") String nit) {
        Company company = null;
        Optional<Company> optCompany = companyRepository.findById(nit);
        company = optCompany.get();
        return company;
    }


    @GetMapping(path = "/company")
    public @ResponseBody
    List<Company> getCompanies() {
        return companyRepository.findAll();
    }

}