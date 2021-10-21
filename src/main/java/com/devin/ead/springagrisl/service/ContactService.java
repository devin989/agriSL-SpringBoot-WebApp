package com.devin.ead.springagrisl.service;


import com.devin.ead.springagrisl.model.Contact;
import com.devin.ead.springagrisl.repositary.ContactRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepositary contactRepositary;

    public void saveContact(Contact contact) {
        this.contactRepositary.save(contact);
    }
}
