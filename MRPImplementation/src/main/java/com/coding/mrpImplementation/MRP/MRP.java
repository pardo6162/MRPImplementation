package com.coding.mrpImplementation.MRP;

import com.coding.mrpImplementation.entities.Material;
import com.coding.mrpImplementation.exceptions.MRPException;
import com.coding.mrpImplementation.service.Service;

public interface MRP {
    int execute(Service service, Material material, int time) throws MRPException;
}

