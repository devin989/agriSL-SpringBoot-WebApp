package com.devin.ead.springagrisl.repositary;


import com.devin.ead.springagrisl.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepositary extends JpaRepository<Contact,Long> {

}
