package com.devin.ead.springagrisl.controller;

import com.devin.ead.springagrisl.model.Buyer;
import com.devin.ead.springagrisl.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    // display list of suppliers
    @GetMapping("/buyers")
    public String viewBuyerPage(Model model) {
        model.addAttribute("listBuyers", buyerService.getAllBuyers());
        return "buyer";
    }

    @GetMapping("/showNewBuyerForm")
    public String showNewBuyerForm(Model model) {
        // create model attribute to bind form data
        Buyer buyer = new Buyer();
        model.addAttribute("buyer", buyer);
        return "new_buyer";
    }

    @PostMapping("/saveBuyer")
    public String saveBuyer(@ModelAttribute("buyer") Buyer buyer) {
        // save employee to database
        buyerService.saveBuyer(buyer);
        return "redirect:/buyers";
    }

    @GetMapping("/showBuyerFormForUpdate/{id}")
    public String showBuyerFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get supplier from the service
        Buyer buyer = buyerService.getBuyerById(id);

        // set supplier as a model attribute to pre-populate the form
        model.addAttribute("buyer", buyer);

        return "update_buyer";
    }

    @GetMapping("/deleteBuyer/{id}")
    public String deleteBuyer(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.buyerService.deleteBuyerById(id);
        return "redirect:/buyers";

    }
}
