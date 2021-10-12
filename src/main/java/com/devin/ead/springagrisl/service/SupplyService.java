package com.devin.ead.springagrisl.service;


import com.devin.ead.springagrisl.model.Supplier;
import com.devin.ead.springagrisl.repositary.SupplyRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyService {

    @Autowired
    private SupplyRepositary supplyRepositary;

    public List<Supplier> getAllSuppliers() {
        return supplyRepositary.findAll();
    }

    public void saveSupplier(Supplier supplier) {
        this.supplyRepositary.save(supplier);
    }

    public Supplier getSupplierById(long id) {
        Optional<Supplier> optional = supplyRepositary.findById(id);
        Supplier supplier = null;
        if (optional.isPresent()) {
            supplier = optional.get();
        } else {
            throw new RuntimeException(" Supplier not found for id :: " + id);
        }
        return supplier;
    }
    public void deleteSupplierById(long id) {
        this.supplyRepositary.deleteById(id);
    }

}
