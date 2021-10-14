package com.devin.ead.springagrisl.model;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "wanted_items")
    private String wantedItems;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private String date;

    @Column(name = "kg")
    private String KG;



    public String getWantedItems() {
        return wantedItems;
    }

    public void setWantedItems(String wantedItems) {
        this.wantedItems = wantedItems;
    }

    public String getKG() {
        return KG;
    }

    public void setKG(String KG) {
        this.KG = KG;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

