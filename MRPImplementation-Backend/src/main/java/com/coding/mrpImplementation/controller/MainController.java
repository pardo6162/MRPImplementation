package com.coding.mrpImplementation.controller;


import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.persistence.ActivityRepository;
import com.coding.mrpImplementation.service.persistence.CompanyRepository;
import com.coding.mrpImplementation.service.persistence.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
        //List<Machine> machines=company.getMachines();
        //machines.add(machine);
        //company.setMachines(machines);
        machine.setCompany(company);
        machineRepository.save(machine);
        //companyRepository.save(company);
        return "Saved";
    }

    @GetMapping(path="/company/{nit}/machine")
    public  @ResponseBody List<Machine> getMachines (@PathVariable(value="nit")String nit){
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
            company.getMachines().remove(machine);
            companyRepository.save(company);
            machineRepository.delete(machine);
            resp="Deleted";
        }

        return resp;
    }

    @PostMapping(path="/company/{nit}/machine/{id}/activity")
    public  @ResponseBody String addActivity(@PathVariable(value="nit") String nit,@PathVariable(value = "id")String id,@RequestBody Activity activity){
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(id).get();
        String resp="The company don´t contains this machine";
        if(machine.getCompany().equals(company)) {
            List<Activity> activities = machine.getActivities();
            activities.add(activity);
            machine.setActivities(activities);
            activity.setMachine(machine);
            machineRepository.save(machine);
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
                activityRepository.delete(activity);
                resp="Deleted";
            }else{
                resp="The machine doesn´t contain the activity";
            }
        }
        return resp;
    }




}
