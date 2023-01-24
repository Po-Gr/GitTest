package ru.consist.models;

import java.util.HashMap;
import java.util.Map;

public class PassportUtil {

    public static Map<String, Object> getPassportFields(Passport passport) {
        Map<String, Object> fields = new HashMap<>();

        fields.put("passportId", passport.passportId);
        fields.put("passportNumber", passport.passportNumber);
        fields.put("authority", passport.authority);
        fields.put("dateOfIssue", passport.dateOfIssue);

        return fields;
    }
}
