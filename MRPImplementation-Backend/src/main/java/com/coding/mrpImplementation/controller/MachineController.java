package com.coding.mrpImplementation.controller;

import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.service.persistence.CompanyRepository;
import com.coding.mrpImplementation.service.persistence.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/mrp")
public class MachineController extends MRPController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MachineRepository machineRepository;

    @PostMapping(path="/company/{nit}/machine")
    public  @ResponseBody
    String addMachine (@PathVariable(value="nit")String nit, @RequestBody Machine machine){
        Company company=companyRepository.findById(nit).get();
        machine.setCompany(company);
        machineRepository.save(machine);
        return "Saved";
    }

    @GetMapping(path="/company/{nit}/machine")
    public  @ResponseBody   List<Machine> getMachines (@PathVariable(value="nit")String nit){
        Company company=companyRepository.findById(nit).get();
        List<Machine> machines=company.getMachines();
        return machines;
    }


    @DeleteMapping(path="/company/{nit}/machine/{id}")
    public @ResponseBody String deleteMachine(@PathVariable(value = "nit")String nit,@PathVariable(value="id")String id){
        String resp="The company doesn't contain the machine";
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(id).get();
        if(machine.getCompany().equals(company)){
            machine.setCompany(null);
            machineRepository.delete(machine);
            resp="Deleted";
        }

        return resp;
    }
}
