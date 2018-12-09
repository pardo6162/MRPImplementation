package com.coding.mrpImplementation.controller;


import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Supplier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path="/mrp")
public class SupplierController extends MRPController {

    @PostMapping(path = "/supplier")
    public @ResponseBody ResponseEntity<?> addSupplier(@RequestBody Supplier supplier){
        supplierRepository.save(supplier);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/supplier")
    public @ResponseBody List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    @DeleteMapping(path = "/supplier/{id}")
    public @ResponseBody ResponseEntity<?> deleteSupplier(@PathVariable(value="id") String id){
        Supplier supplier=supplierRepository.findById(id);
        supplierRepository.delete(supplier);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
