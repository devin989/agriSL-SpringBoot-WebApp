package com.devin.ead.springagrisl.service;


import com.devin.ead.springagrisl.model.Buyer;
import com.devin.ead.springagrisl.repositary.BuyerRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepositary buyerRepositary;

    public List<Buyer> getAllBuyers() {
        return buyerRepositary.findAll();
    }

    public void saveBuyer(Buyer buyer) {
        this.buyerRepositary.save(buyer);
    }

    public Buyer getBuyerById(long id) {
        Optional<Buyer> optional = buyerRepositary.findById(id);
        Buyer buyer = null;
        if (optional.isPresent()) {
            buyer = optional.get();
        } else {
            throw new RuntimeException(" Buyer not found for id :: " + id);
        }
        return buyer;
    }
    public void deleteBuyerById(long id) {
        this.buyerRepositary.deleteById(id);
    }

}
