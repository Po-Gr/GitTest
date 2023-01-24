package ru.consist.models;

import java.util.HashMap;
import java.util.Map;

public class ParcelUtil {

    public static Map <String, Object> getParcelFields(Parcel parcel) {
        Map<String, Object> fields = new HashMap<>();

        fields.put("parcelNumber", parcel.parcelNumber);
        fields.put("sender", parcel.sender);
        fields.put("sendingAddress", parcel.sendingAddress);
        fields.put("recipient", parcel.recipient);
        fields.put("destinationAddress", parcel.destinationAddress);
        fields.put("status", parcel.status);

        return fields;
    }
}
