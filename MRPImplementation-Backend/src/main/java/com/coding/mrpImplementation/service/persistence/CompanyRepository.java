package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Integer> {
}
