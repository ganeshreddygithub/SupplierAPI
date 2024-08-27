package com.example.SearchAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.example.SearchAPI.model.Supplier;
import com.example.SearchAPI.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public Page<Supplier> querySuppliers(@RequestParam String location,
                                         @RequestParam String natureOfBusiness,
                                         @RequestParam String manufacturingProcess,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        return supplierService.searchSuppliers(location, natureOfBusiness, manufacturingProcess, PageRequest.of(page, size));
    }
}
