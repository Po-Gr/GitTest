package ru.consist.dto;

import java.util.UUID;

public class ParcelDto {

    private UUID parcelNumber;

    private PersonDto sender;

    private AddressDto sendingAddress;

    private PersonDto recipient;

    private AddressDto destinationAddress;

    private ParcelStatusDto status;

    public ParcelDto() {
    }

    public ParcelDto(UUID parcelNumber, PersonDto sender, AddressDto sendingAddress, PersonDto recipient, AddressDto destinationAddress, ParcelStatusDto status) {
        this.parcelNumber = parcelNumber;
        this.sender = sender;
        this.sendingAddress = sendingAddress;
        this.recipient = recipient;
        this.destinationAddress = destinationAddress;
        this.status = status;
    }

    public PersonDto getSender() {
        return sender;
    }

    public void setSender(PersonDto sender) {
        this.sender = sender;
    }

    public AddressDto getSendingAddress() {
        return sendingAddress;
    }

    public void setSendingAddress(AddressDto sendingAddress) {
        this.sendingAddress = sendingAddress;
    }

    public PersonDto getRecipient() {
        return recipient;
    }

    public void setRecipient(PersonDto recipient) {
        this.recipient = recipient;
    }

    public AddressDto getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(AddressDto destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public UUID getParcelNumber() {
        return parcelNumber;
    }

    public void setParcel_number(UUID parcel_number) {
        this.parcelNumber = parcel_number;
    }

    public ParcelStatusDto getStatus() {
        return status;
    }

    public void setStatus(ParcelStatusDto status) {
        this.status = status;
    }
}
