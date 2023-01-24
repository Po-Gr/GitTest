package ru.consist.models;

import java.util.UUID;

public class Parcel {

    protected UUID parcelNumber;

    protected Person sender;

    protected Address sendingAddress;

    protected Person recipient;

    protected Address destinationAddress;

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
