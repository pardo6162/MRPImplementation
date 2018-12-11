package com.coding.mrpImplementation.controller;

import com.coding.mrpImplementation.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/mrp")
public class MaterialController extends MRPController{

    @PutMapping(path="/company/{nit}/machine/{id_machine}/activity/{id_activity}/material/{id_material}")
    public @ResponseBody ResponseEntity<?> addMaterialToActivity(@PathVariable(value="nit")String nit, @PathVariable(value="id_machine")String idMachine, @PathVariable(value="id_activity") String idActivity,@PathVariable(value="id_material") String idMaterial ){
        ResponseEntity<?> responseEntity=new ResponseEntity<>("The machine doesn't exists",HttpStatus.BAD_REQUEST);
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(idMachine).get();
        Activity activity=activityRepository.findById(idActivity).get();
        Material material=materialRepository.findById(idMaterial);
        if(machine.getCompany().equals(company)) {
            if (activity.getMachine().equals(machine)) {
                List<Material> listMaterialActivity = activity.getMaterials();
                List<Activity> listActivityMaterial = material.getActivities();
                listMaterialActivity.add(material);
                activity.setMaterials(listMaterialActivity);
                listActivityMaterial.add(activity);
                material.setActivities(listActivityMaterial);
                activityRepository.save(activity);
                materialRepository.save(material);
            }else{
                responseEntity=new ResponseEntity<>("The activity doesn't exists",HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/company/{nit}/machine/{id_machine}/activity/{id_activity}/material")
    public @ResponseBody List<Material> getMaterials(@PathVariable(value="nit")String nit, @PathVariable(value="id_machine")String idMachine, @PathVariable(value="id_activity") String idActivity){
        List<Material> materials= new ArrayList<>();
        List<Material> materialsResp= new ArrayList<>();
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(idMachine).get();
        Activity activity=activityRepository.findById(idActivity).get();
        if(machine.getCompany().equals(company)) {
            if (activity.getMachine().equals(machine)) {
                materials=materialRepository.findAll();
                for(Material i:materials){
                    if(i.getActivities().contains(activity)){
                        materialsResp.add(i);
                    }
                }
            }
        }
        return materials;
    }


    @DeleteMapping(path="/company/{nit}/machine/{id_machine}/activity/{id_activity}/material/{id_material}")
    public @ResponseBody ResponseEntity<?> deleteMaterial(@PathVariable(value="nit")String nit, @PathVariable(value="id_machine")String idMachine, @PathVariable(value="id_activity" ) String idActivity,@PathVariable(value="id_material" ) String idMaterial ){
        ResponseEntity<?> responseEntity=new ResponseEntity<>("The machine doesn't exists",HttpStatus.BAD_REQUEST);
        Company company=companyRepository.findById(nit).get();
        Machine machine=machineRepository.findById(idMachine).get();
        Activity activity=activityRepository.findById(idActivity).get();
        Material material=materialRepository.findById(idMaterial);
        if(machine.getCompany().equals(company)) {
            if (activity.getMachine().equals(machine)) {
                material.getActivities().clear();
                material.getSuppliers().clear();
                materialRepository.delete(material);
            }else{
                responseEntity=new ResponseEntity<>("The activity doesn't exists",HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/supplier/{id}/material")
    public @ResponseBody ResponseEntity<?> addMaterialToSupplier(@PathVariable(value="id")String id,@RequestBody Material material){
        Supplier supplier=supplierRepository.findById(id);
        List<Material> listMaterials =supplier.getMaterials();
        List<Supplier> listSupplier= new ArrayList<>();
        listMaterials.add(material);
        listSupplier.add(supplier);
        supplierRepository.save(supplier);
        materialRepository.save(material);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
