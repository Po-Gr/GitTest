package ru.consist.dto;

public class AddressDto {

    private String country;

    private String city;

    private String locality;

    private String street;

    private String house;

    private String apartment;

    private int postalCode;

    public AddressDto() {
    }

    public AddressDto(String country, String city, String locality, String street, String house, String apartment, int postalCode) {
        this.country = country;
        this.city = city;
        this.locality = locality;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getLocality() {
        return locality;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getApartment() {
        return apartment;
    }

    public int getPostalCode() {
        return postalCode;
    }
}
