package com.coding.mrpImplementation.controller;

import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import com.coding.mrpImplementation.service.persistence.CompanyRepository;
import com.coding.mrpImplementation.service.persistence.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/mrp")
public class ActivityController extends MRPController {



    @PostMapping(path="/company/{nit}/machine/{id}/activity")
    public  @ResponseBody
    String addActivity(@PathVariable(value="nit") String nit, @PathVariable(value = "id")String id, @RequestBody Activity activity){
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(id).get();
        String resp="The company don´t contains this machine";
        if(machine.getCompany().equals(company)) {
            activity.setMachine(machine);
            activityRepository.save(activity);
            resp = "Saved";
        }
        return  resp;
    }

    @GetMapping(path = "/company/{nit}/machine/{id}/activity")
    public @ResponseBody List<Activity> getActivities(@PathVariable(value = "nit")String  nit,@PathVariable(value = "id")String id){
        List<Activity> activities=null;
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(id).get();
        String resp="The company doesn´t contain this machine";
        if(machine.getCompany().equals(company)) {
            activities=machine.getActivities();
        }
        return activities;
    }

    @DeleteMapping(path="/company/{nit}/machine/{id_machine}/activity/{id_activity}")
    public @ResponseBody String deleteActivity(@PathVariable(value = "nit")String nit,@PathVariable(value="id_machine")String id_machine,@PathVariable(value="id_activity") String id_activity){
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(id_machine).get();
        Activity activity=activityRepository.findById(id_activity).get();
        String resp="The company doesn´t contain this machine";
        if(company.getMachines().contains(machine)) {
            if(activity.getMachine().equals(machine)){
                activity.setMachine(null);
                activityRepository.delete(activity);
                resp="Deleted";
            }else{
                resp="The machine doesn´t contain the activity";
            }
        }
        return resp;
    }
}
