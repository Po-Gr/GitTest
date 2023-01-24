package ru.consist.dtoMappers;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.consist.dto.*;
import ru.consist.models.*;
import ru.consist.services.ParcelService;

import java.util.Map;
import java.util.UUID;

@Component
public class ParcelDtoMapper {

    private final ParcelService parcelService;

    @Autowired
    public ParcelDtoMapper(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    public ParcelDto mapForGet(Parcel parcel) {
        Map<String, Object> map = ParcelUtil.getParcelFields(parcel);

        Person sender = (Person) map.get("sender");
        Person recipient = (Person) map.get("recipient");
        Address sendingAddress = (Address) map.get("sendingAddress");
        Address destinationAddress = (Address) map.get("destinationAddress");
        ParcelStatus status = (ParcelStatus) map.get("status");

        map = PersonUtil.getPersonFields(sender);
        Passport senderPassport = (Passport) map.get("passport");

        map = PassportUtil.getPassportFields(senderPassport);
        PassportDto senderPassportDto = new PassportDto((Integer) map.get("passportNumber"), (String) map.get("authority"), (LocalDateTime) map.get("dateOfIssue"));

        map = PersonUtil.getPersonFields(sender);
        PersonDto senderDto = new PersonDto((String) map.get("name"), (String) map.get("surname"), (String)map.get("patronymic"),
                (String) map.get("phone"), senderPassportDto);

        map = PersonUtil.getPersonFields(recipient);
        PersonDto recipientDto = new PersonDto((String) map.get("name"), (String) map.get("surname"), (String)map.get("patronymic"), (String) map.get("phone"));

        map = AddressUtil.getAddressFields(sendingAddress);
        AddressDto sendingAddressDto = new AddressDto((String) map.get("country"), (String) map.get("city"), (String) map.get("locality"),
                (String) map.get("street"), (String) map.get("house"), (String) map.get("apartment"), (Integer) map.get("postalCode"));

        map = AddressUtil.getAddressFields(destinationAddress);
        AddressDto destinationAddressDto = new AddressDto((String) map.get("country"), (String) map.get("city"), (String) map.get("locality"),
                (String) map.get("street"), (String) map.get("house"), (String) map.get("apartment"), (Integer) map.get("postalCode"));

        map = ParcelStatusUtil.getStatusFields(status);
        ParcelStatusDto statusDto = new ParcelStatusDto((Integer) map.get("statusCode"), (String) map.get("statusName"));

        map = ParcelUtil.getParcelFields(parcel);
        ParcelDto dto = new ParcelDto((UUID)map.get("parcelNumber"), senderDto, sendingAddressDto, recipientDto, destinationAddressDto, statusDto);

        return dto;
    }

    public Parcel mapForCreate(ParcelDto dto) {
        PersonDto senderDto = dto.getSender();
        PassportDto senderPassportDto = senderDto.getPassport();
        AddressDto sendingAddressDto = dto.getSendingAddress();
        PersonDto recipientDto = dto.getRecipient();
        AddressDto destinationAddressDto = dto.getDestinationAddress();

        Passport senderPassport = new Passport(senderPassportDto.getPassportNumber(), senderPassportDto.getAuthority(), senderPassportDto.getDateOfIssue());
        Person sender = new Person(senderDto.getName(), senderDto.getSurname(), senderDto.getPatronymic(), senderDto.getPhone(), senderPassport);
        Address sendingAddress = new Address(sendingAddressDto.getCountry(), sendingAddressDto.getCity(), sendingAddressDto.getLocality(),
                sendingAddressDto.getStreet(), sendingAddressDto.getHouse(), sendingAddressDto.getApartment(), sendingAddressDto.getPostalCode());
        Person recipient = new Person(recipientDto.getName(), recipientDto.getSurname(), recipientDto.getPatronymic(), recipientDto.getPhone(), null); // подумать
        Address destinationAddress = new Address(destinationAddressDto.getCountry(), destinationAddressDto.getCity(), destinationAddressDto.getLocality(),
                destinationAddressDto.getStreet(), destinationAddressDto.getHouse(), destinationAddressDto.getApartment(), destinationAddressDto.getPostalCode());

        return new Parcel(sender, sendingAddress, recipient, destinationAddress);
    }

    public Parcel mapForUpdate(ParcelDto dto, UUID parcelNumber) {
        PersonDto senderDto = dto.getSender();
        PassportDto senderPassportDto = senderDto.getPassport();
        AddressDto sendingAddressDto = dto.getSendingAddress();
        PersonDto recipientDto = dto.getRecipient();
        AddressDto destinationAddressDto = dto.getDestinationAddress();
        ParcelStatusDto statusDto = dto.getStatus();

        Parcel parcel = parcelService.findParcelById(parcelNumber).get(0);

        UUID senderPassportId = (UUID) PassportUtil.getPassportFields((Passport) PersonUtil
                .getPersonFields((Person) ParcelUtil.getParcelFields(parcel).get("sender")).get("passport")).get("passportId");
        Passport senderPassport = new Passport(senderPassportId, senderPassportDto.getPassportNumber(), senderPassportDto.getAuthority(), senderPassportDto.getDateOfIssue());

        Person sender = new Person((UUID) PersonUtil.getPersonFields((Person) ParcelUtil.getParcelFields(parcel).get("sender")).get("personId"),
                senderDto.getName(), senderDto.getSurname(), senderDto.getPatronymic(), senderDto.getPhone(), senderPassport);
        Address sendingAddress = new Address((UUID) AddressUtil.getAddressFields((Address) ParcelUtil.getParcelFields(parcel).get("sendingAddress")).get("addressId"),
                sendingAddressDto.getCountry(), sendingAddressDto.getCity(), sendingAddressDto.getLocality(), sendingAddressDto.getStreet(),
                sendingAddressDto.getHouse(), sendingAddressDto.getApartment(), sendingAddressDto.getPostalCode());
        Person recipient = new Person((UUID) PersonUtil.getPersonFields((Person) ParcelUtil.getParcelFields(parcel).get("recipient")).get("personId"), recipientDto.getName(),
                recipientDto.getSurname(), recipientDto.getPatronymic(), recipientDto.getPhone(), null);
        Address destinationAddress = new Address((UUID) AddressUtil.getAddressFields((Address) ParcelUtil.getParcelFields(parcel).get("destinationAddress")).get("addressId"),
                destinationAddressDto.getCountry(), destinationAddressDto.getCity(), destinationAddressDto.getLocality(), destinationAddressDto.getStreet(),
                destinationAddressDto.getHouse(), destinationAddressDto.getApartment(), destinationAddressDto.getPostalCode());

        parcel = new Parcel(parcelNumber, sender, sendingAddress, recipient, destinationAddress);

        if (statusDto.getStatusCode() == 2) {
            parcel.inTransit();
        }
        else if (statusDto.getStatusCode() == 3) {
            parcel.inPostOffice();
        }
        else if (statusDto.getStatusCode() == 4) {
            parcel.received();
        }
        else if (statusDto.getStatusCode() == 5) {
            parcel.sentBack();
        }
        else if (statusDto.getStatusCode() == 6) {
            parcel.inPostOfficeOfSender();
        }
        else if (statusDto.getStatusCode() == 7) {
            parcel.receivedBySender();
        }
        else if (statusDto.getStatusCode() == 8) {
            parcel.closed();
        }

        return parcel;
    }

}
