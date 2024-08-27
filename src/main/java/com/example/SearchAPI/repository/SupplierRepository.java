package com.example.SearchAPI.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SearchAPI.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	Page<Supplier> findByManufacturingProcessesContaining(String manufacturingProcess, Pageable pageable);

	Page<Supplier> findByNatureOfBusiness(String natureOfBusiness, Pageable pageable);

	Page<Supplier> findByLocation(String location, Pageable pageable);

	Page<Supplier> findByNatureOfBusinessAndManufacturingProcessesContaining(String natureOfBusiness,
			String manufacturingProcess, Pageable pageable);

	Page<Supplier> findByLocationAndManufacturingProcessesContaining(String location, String manufacturingProcess,
			Pageable pageable);

	Page<Supplier> findByLocationAndNatureOfBusiness(String location, String natureOfBusiness, Pageable pageable);

	Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(String location,
			String natureOfBusiness, String manufacturingProcess, Pageable pageable);
}
