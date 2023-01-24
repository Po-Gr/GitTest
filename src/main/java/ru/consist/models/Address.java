package ru.consist.models;

import java.util.UUID;

/**
 * Доменная модель адреса - является составной частью модели Parcel;
 * Экземпляр класса содержит данные об одресе получателя или отправителя почтовой посылки
 */
public class Address {

    /**
     * Уникальный идентификатор адреса - присваивается в конструкторе при создании нового адреса в системе
     */
    protected UUID addressId;

    /**
     * Для хранения информации о стране
     */
    protected String country;

    /**
     * Для хранения информации о городе, поле не обязательное
     */
    protected String city;

    /**
     * Для хранения информации о населенном пункте, поле не обязательное
     */
    protected String locality;

    /**
     * Для хранения информации об улице
     */
    protected String street;

    /**
     * Для хранения информации о номере дома
     */
    protected String house;

    /**
     * Для хранения информации о номере квартиры, не обязательное поле
     */
    protected String apartment;

    /**
     * Для хранения информации об индексе
     */
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
