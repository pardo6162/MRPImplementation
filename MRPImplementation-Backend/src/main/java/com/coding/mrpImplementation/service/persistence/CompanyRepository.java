package com.coding.mrpImplementation.service.persistence;

import com.coding.mrpImplementation.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company,String> {
   Company save(Company company);
   List<Company> findAll();
   Optional<Company> findById(String id);
   boolean existsById(String id);
   void deleteById(String id);
}
