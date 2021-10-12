package com.devin.ead.springagrisl.controller;

import com.devin.ead.springagrisl.model.Supplier;
import com.devin.ead.springagrisl.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SupplyController {

    @Autowired
    private SupplyService supplyService;

    // display list of suppliers
    @GetMapping("/suppliers")
    public String viewSupplierPage(Model model) {
        model.addAttribute("listSuppliers", supplyService.getAllSuppliers());
        return "supplier";
    }

    @GetMapping("/showNewSupplierForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "new_supplier";
    }

    @PostMapping("/saveSupplier")
    public String saveSupplier(@ModelAttribute("supplier") Supplier supplier) {
        // save employee to database
        supplyService.saveSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get supplier from the service
        Supplier supplier = supplyService.getSupplierById(id);

        // set supplier as a model attribute to pre-populate the form
        model.addAttribute("supplier", supplier);

        return "update_supplier";
    }

    @GetMapping("/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.supplyService.deleteSupplierById(id);
        return "redirect:/suppliers";

    }
}
