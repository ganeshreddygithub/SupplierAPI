package com.example.SearchAPI.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    
    private String companyName;
    private String website;
    private String location;
    private String natureOfBusiness;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "supplier_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "manufacturing_process")
    private Set<String> manufacturingProcesses;
}

