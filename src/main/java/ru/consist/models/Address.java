package ru.consist.models;

import java.util.UUID;

public class Address {

    protected UUID addressId;

    protected String country;

    protected String city;

    protected String locality;

    protected String street;

    protected String house;

    protected String apartment;

    protected int postalCode;

    public Address(String country, String city, String locality, String street, String house, String apartment, int postalCode) {
        addressId = UUID.randomUUID();
        this.country = country;
        this.city = city;
        this.locality = locality;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postalCode = postalCode;
    }

    public Address(UUID addressId, String country, String city, String locality, String street, String house, String apartment, int postalCode) {
        this.addressId = addressId;
        this.country = country;
        this.city = city;
        this.locality = locality;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postalCode = postalCode;
    }
}
