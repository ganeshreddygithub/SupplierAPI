package com.example.SearchAPI.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.SearchAPI.model.Supplier;
import com.example.SearchAPI.repository.SupplierRepository;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> searchSuppliers(String location, String natureOfBusiness, String manufacturingProcess, Pageable pageable) {
        
        if (location != null && natureOfBusiness != null && manufacturingProcess != null) {
            return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
                    location, natureOfBusiness, manufacturingProcess, pageable);
        }else if (location != null && natureOfBusiness != null) {
            return supplierRepository.findByLocationAndNatureOfBusiness(location, natureOfBusiness, pageable);
        }else if (location != null && manufacturingProcess != null) {
            return supplierRepository.findByLocationAndManufacturingProcessesContaining(location, manufacturingProcess, pageable);
        }else if (natureOfBusiness != null && manufacturingProcess != null) {
            return supplierRepository.findByNatureOfBusinessAndManufacturingProcessesContaining(natureOfBusiness, manufacturingProcess, pageable);
        }else if (location != null) {
            return supplierRepository.findByLocation(location, pageable);
        }else if (natureOfBusiness != null) {
            return supplierRepository.findByNatureOfBusiness(natureOfBusiness, pageable);
        }else if (manufacturingProcess != null) {
            return supplierRepository.findByManufacturingProcessesContaining(manufacturingProcess, pageable);
        }else {
            return supplierRepository.findAll(pageable);
        }
    }
}
