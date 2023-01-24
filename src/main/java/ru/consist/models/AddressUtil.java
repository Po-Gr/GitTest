package ru.consist.models;

import java.util.HashMap;
import java.util.Map;

public class AddressUtil {

    public static Map<String, Object> getAddressFields(Address address) {
        Map<String, Object> fields = new HashMap<>();

        fields.put("addressId", address.addressId);
        fields.put("country", address.country);
        fields.put("city", address.city);
        fields.put("locality", address.locality);
        fields.put("street", address.street);
        fields.put("house", address.house);
        fields.put("apartment", address.apartment);
        fields.put("postalCode", address.postalCode);

        return fields;
    }
}
