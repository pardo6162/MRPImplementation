package com.coding.mrpImplementation.controller;


import com.coding.mrpImplementation.model.Activity;
import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Machine;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;



public abstract class MRPController {
    @Autowired
    protected ActivityRepository activityRepository;

    @Autowired
    protected CompanyRepository companyRepository;

    @Autowired
    protected MachineRepository machineRepository;

    @Autowired
    protected MaterialRepository materialRepository;

    @Autowired
    protected SupplierRepository supplierRepository;


}
