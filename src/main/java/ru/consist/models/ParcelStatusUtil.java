package ru.consist.models;

import java.util.HashMap;
import java.util.Map;

public class ParcelStatusUtil {

    public static Map<String, Object> getStatusFields(ParcelStatus parcelStatus) {

        Map<String, Object> fields = new HashMap<>();

        fields.put("statusCode", parcelStatus.statusCode);
        fields.put("statusName", parcelStatus.statusName);

        return fields;
    }
}
