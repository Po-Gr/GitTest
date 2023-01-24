package ru.consist.models;

import java.util.HashMap;
import java.util.Map;

public class PersonUtil {

    public static Map<String, Object> getPersonFields(Person person) {
        Map<String, Object> fields = new HashMap<>();

        fields.put("personId", person.personId);
        fields.put("name", person.name);
        fields.put("surname", person.surname);
        fields.put("patronymic", person.patronymic);
        fields.put("phone", person.phone);
        fields.put("passport", person.passport);

        return fields;
    }
}
