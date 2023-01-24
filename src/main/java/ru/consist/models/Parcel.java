package ru.consist.models;

import java.util.UUID;

/**
 * Доменная модель посылки - центральная сущность программы;
 * Класс для создания в системе почтовых посылок, хранящих в себе данные об отправителе и получателе, об адресах отправителя и получателя и статусе посылки
 */

public class Parcel {

    /**
     * Уникальный идентификатор посылки - присваивается в конструкторе при создании новой посылки в системе
     */
    protected UUID parcelNumber;

    /**
     * Для хранения информации об отправителе посылки
     */
    protected Person sender;

    /**
     * Для хранения информации об адресе отправителя посылки
     */
    protected Address sendingAddress;

    /**
     * Для хранения информации об получателя посылки
     */
    protected Person recipient;

    /**
     * Для хранения информации об адреса получателя посылки
     */
    protected Address destinationAddress;

    /**
     * Для хранения информации о статусе посылки
     */
    protected ParcelStatus status;

    public Parcel(Person sender, Address sendingAddress, Person recipient, Address destinationAddress) {
        parcelNumber = UUID.randomUUID();
        this.sender = sender;
        this.sendingAddress = sendingAddress;
        this.recipient = recipient;
        this.destinationAddress = destinationAddress;
        this.status = new ParcelStatus(1, "accepted_for_transportation");
    }

    public Parcel(UUID parcelNumber, Person sender, Address sendingAddress, Person recipient, Address destinationAddress, ParcelStatus status) {
        this.parcelNumber = parcelNumber;
        this.sender = sender;
        this.sendingAddress = sendingAddress;
        this.recipient = recipient;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }

    public Parcel(UUID parcelNumber, Person sender, Address sendingAddress, Person recipient, Address destinationAddress) {
        this.parcelNumber = parcelNumber;
        this.sender = sender;
        this.sendingAddress = sendingAddress;
        this.recipient = recipient;
        this.destinationAddress = destinationAddress;
        this.status = new ParcelStatus(1, "accepted_for_transportation");
    }

    /**
     * Методы изменения статуса посылки
     */
    public void inTransit() {
        this.status = new ParcelStatus(2, "in_transit");
    }

    public void inPostOffice() {
        this.status = new ParcelStatus(3, "in_post_office");
    }

    public void received() {
        this.status = new ParcelStatus(4, "received");
    }

    public void sentBack() {
        this.status = new ParcelStatus(5, "sent_back");
    }

    public void inPostOfficeOfSender() {
        this.status = new ParcelStatus(6, "in_post_office_of_sender");
    }

    public void receivedBySender() {
        this.status = new ParcelStatus(7, "received_by_sender");
    }

    public void closed() {
        this.status = new ParcelStatus(8, "closed");
    }
}
