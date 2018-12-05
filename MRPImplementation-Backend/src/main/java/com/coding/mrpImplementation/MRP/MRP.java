package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.MRP.exception.MRPException;
import com.coding.mrpImplementation.model.Company;
import com.coding.mrpImplementation.model.Material;
import com.coding.mrpImplementation.service.Service;

public interface MRP {
    int execute(Service service, Material material, int timeIndex, Company company) throws MRPException;
}

